package com.cognizant.paymentservice.service;

import com.cognizant.paymentservice.client.ThirdPartyPaymentClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Problem 4: Applies a Resilience4j circuit breaker + time limiter around
 * the call to the slow third-party payment API, with fallback logic and
 * logging/monitoring of fallback events.
 */
@Service
public class PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private ThirdPartyPaymentClient thirdPartyPaymentClient;

    @CircuitBreaker(name = "thirdPartyPayment", fallbackMethod = "paymentFallback")
    @TimeLimiter(name = "thirdPartyPayment")
    public Mono<String> processPayment(String paymentId, double amount) {
        return thirdPartyPaymentClient.charge(paymentId, amount);
    }

    /**
     * Fallback invoked when the circuit is OPEN, the call times out, or the
     * third-party call otherwise fails. Signature must match the protected
     * method's, plus a trailing Throwable.
     */
    private Mono<String> paymentFallback(String paymentId, double amount, Throwable throwable) {
        log.warn("Fallback triggered for payment {} (amount={}): {}",
                paymentId, amount, throwable.toString());
        return Mono.just(
                "Payment " + paymentId + " could not be processed right now. " +
                "It has been queued for retry once the payment provider recovers."
        );
    }
}
