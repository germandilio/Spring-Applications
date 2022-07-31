package ru.germandilio.thymeleaf_demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.logging.LoggingPermission;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = Logger.getLogger(LoggingPermission.class.getName());

    @Before("execution(* ru.germandilio.thymeleaf_demo.service.*.*(..))")
    public void logServicePackage(JoinPoint joinPoint) {
        logger.info("calling method " + joinPoint.getSignature().toShortString() +
                " with args: " + Arrays.toString(joinPoint.getArgs()));
    }
}
