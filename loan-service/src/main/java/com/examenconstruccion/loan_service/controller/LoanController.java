package com.examenconstruccion.loan_service.controller;

import com.examenconstruccion.loan_service.model.Loan;
import com.examenconstruccion.loan_service.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public Loan createLoan(@RequestParam Long bookId, @RequestParam Long memberId) {
        return loanService.createLoan(bookId, memberId);
    }
}
