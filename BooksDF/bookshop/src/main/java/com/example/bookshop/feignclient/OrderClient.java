package com.example.bookshop.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "order", url = "http://localhost:8082", path="/orders")
public interface OrderClient {

    @GetMapping("/report")
    String getReport();
}
