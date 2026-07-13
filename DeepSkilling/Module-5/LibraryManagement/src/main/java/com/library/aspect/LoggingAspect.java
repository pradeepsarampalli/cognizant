package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Exercise 3: Aspect that logs method execution time for all methods in the
 * com.library.service package.
 * Exercise 8: Adds simple "before" and "after" advice to demonstrate basic
 * cross-cutting logging, in addition to the execution-time advice.
 *
 * Registered either via component scanning (@Component) together with
 * <aop:aspectj-autoproxy/>, or explicitly as a <bean> in
 * applicationContext-aop.xml - both approaches are shown in this project.
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    // Exercise 8: advice that runs before any service method executes.
    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entering method: {}", joinPoint.getSignature().toShortString());
    }

    // Exercise 8: advice that runs after any service method executes.
    @After("execution(* com.library.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("Exiting method: {}", joinPoint.getSignature().toShortString());
    }

    // Exercise 3: around advice that measures and logs execution time.
    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsed = System.currentTimeMillis() - start;
        log.info("{} executed in {} ms", joinPoint.getSignature().toShortString(), elapsed);
        return result;
    }
}
