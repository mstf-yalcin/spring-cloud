package com.spring.microservices.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cards", path = "/api")
public interface CardsFeignClient {
    @GetMapping("/get/{phoneNumber}")
    ResponseEntity<String> getData(@PathVariable String phoneNumber);
}
