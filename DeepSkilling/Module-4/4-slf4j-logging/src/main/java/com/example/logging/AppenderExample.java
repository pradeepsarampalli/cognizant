package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 3: Using Different Appenders
 *
 * This class doesn't configure appenders in code - that's done declaratively
 * in src/main/resources/logback.xml. Logback wires the CONSOLE and FILE
 * appenders to the root logger, so every log statement below is written to
 * both the console and to app.log.
 */
public class AppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.info("Application started");
        logger.debug("Loading configuration from classpath");

        for (int i = 1; i <= 3; i++) {
            logger.info("Processing task {} of 3", i);
        }

        logger.warn("Configuration value 'timeout' not set, using default of 30s");
        logger.error("Unexpected shutdown signal received");

        logger.info("Application finished - check both the console and app.log");
    }
}
