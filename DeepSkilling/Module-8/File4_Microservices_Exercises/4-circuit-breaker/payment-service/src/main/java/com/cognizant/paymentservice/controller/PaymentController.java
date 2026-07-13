package com.cognizant.paymentservice.controller;

import com.cognizant.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payments")
    public Mono<String> pay(@RequestParam String paymentId, @RequestParam double amount) {
        return paymentService.processPayment(paymentId, amount);
    }
}
