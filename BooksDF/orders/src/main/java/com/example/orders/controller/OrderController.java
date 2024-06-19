package com.example.orders.controller;

import com.example.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/print")
    public ResponseEntity<String> printOrderSummary() {
        orderService.generateOrderSummary();
        return ResponseEntity.ok("Order summary generated successfully");
    }

    @GetMapping("/report")
    public ResponseEntity<String> getReport() {
        String report = orderService.generateOrderReport();
        return ResponseEntity.ok(orderService.generateOrderReport());
    }
}
