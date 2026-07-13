package com.cognizant.paymentservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Wraps the call to the (slow, unreliable) third-party payment API.
 * This is the call that PaymentService protects with a circuit breaker.
 */
@Component
public class ThirdPartyPaymentClient {

    @Autowired
    private WebClient thirdPartyPaymentWebClient;

    public Mono<String> charge(String paymentId, double amount) {
        return thirdPartyPaymentWebClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> "Charged " + amount + " for payment " + paymentId);
    }
}
