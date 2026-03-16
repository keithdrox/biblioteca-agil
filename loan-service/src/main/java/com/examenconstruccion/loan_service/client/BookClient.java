package com.examenconstruccion.loan_service.client;

import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service", url = "http://localhost:8081/api/books")
public interface BookClient {
    @GetMapping("/{id}")
    BookDTO getBookById(@PathVariable("id") Long id);

    @Data
    class BookDTO {
        private Long id;
        private String title;
        private String author;
        private boolean available;
    }
}
