package com.examenconstruccion.loan_service.service;

import com.examenconstruccion.loan_service.client.BookClient;
import com.examenconstruccion.loan_service.client.MemberClient;
import com.examenconstruccion.loan_service.model.Loan;
import com.examenconstruccion.loan_service.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookClient bookClient;

    @Autowired
    private MemberClient memberClient;

    public Loan createLoan(Long bookId, Long memberId) {
        // Validate if book and member exist
        BookClient.BookDTO book = bookClient.getBookById(bookId);
        MemberClient.MemberDTO member = memberClient.getMemberById(memberId);

        if (book != null && member != null && book.isAvailable()) {
            Loan loan = new Loan();
            loan.setBookId(bookId);
            loan.setMemberId(memberId);
            loan.setLoanDate(LocalDate.now());
            // Logic to update book availability could be added here (e.g., another Feign call)
            return loanRepository.save(loan);
        }
        return null;
    }
}
