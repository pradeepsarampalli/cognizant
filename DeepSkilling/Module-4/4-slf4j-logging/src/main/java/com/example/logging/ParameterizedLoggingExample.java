package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 2: Parameterized Logging
 *
 * Parameterized logging (using {} placeholders) avoids the cost of building
 * the log message string when the log level is disabled, since SLF4J only
 * performs the substitution if the message will actually be logged.
 */
public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "pradeep";
        int loginAttempts = 3;

        // Single parameter
        logger.info("User {} logged in successfully", username);

        // Multiple parameters
        logger.warn("User {} has failed to log in {} times", username, loginAttempts);

        // Logging an exception with a parameterized message
        try {
            processOrder("ORD-1001");
        } catch (Exception e) {
            logger.error("Failed to process order {}", "ORD-1001", e);
        }

        // Using varargs for more than two parameters
        logger.debug("Request processed: user={}, action={}, durationMs={}",
                username, "CHECKOUT", 245);
    }

    private static void processOrder(String orderId) throws Exception {
        throw new IllegalStateException("Inventory not available for order " + orderId);
    }
}
