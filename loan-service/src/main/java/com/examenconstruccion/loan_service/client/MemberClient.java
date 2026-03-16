package com.examenconstruccion.loan_service.client;

import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "member-service", url = "http://localhost:8082/api/members")
public interface MemberClient {
    @GetMapping("/{id}")
    MemberDTO getMemberById(@PathVariable("id") Long id);

    @Data
    class MemberDTO {
        private Long id;
        private String name;
        private String email;
    }
}
