package com.cognizant.ems.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Exercise 7 - Enabling Entity Auditing.
 *
 * @EnableJpaAuditing turns on @CreatedDate / @LastModifiedDate handling.
 * The AuditorAware bean supplies the value used for @CreatedBy /
 * @LastModifiedBy - in a real app this would come from the
 * authenticated user (e.g. SecurityContextHolder); here it is stubbed
 * out with a fixed "system" auditor so the project runs without
 * Spring Security configured.
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("system");
    }
}
