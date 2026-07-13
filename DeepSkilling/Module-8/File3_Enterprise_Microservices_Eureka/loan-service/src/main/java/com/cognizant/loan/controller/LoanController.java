package com.cognizant.loan.controller;

import com.cognizant.loan.model.Loan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * GET /loans/{number} -> dummy loan account details, no backend connectivity
 * (per the exercise spec). Runs on port 8081 since account-service already
 * occupies the default 8080.
 */
@RestController
public class LoanController {

    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable String number) {
        return new Loan(number, "car", 400000, 3258, 18);
    }
}
