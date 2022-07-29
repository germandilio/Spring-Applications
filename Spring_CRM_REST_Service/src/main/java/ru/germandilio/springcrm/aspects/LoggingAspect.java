package ru.germandilio.springcrm.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* ru.germandilio.springcrm.controllers.*.*(..))")
    public void logControllers() {}

    @Pointcut("execution(* ru.germandilio.springcrm.dao.*.*(..))")
    public void logDAO() {}

    @Pointcut("execution(* ru.germandilio.springcrm.service.*.*(..))")
    public void logService() {}

    @Pointcut("logControllers() || logDAO() || logService()")
    public void logAppFlow() {}

    @Before("logAppFlow()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("calling method " + joinPoint.getSignature().toShortString() + " with args: "
                + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "logAppFlow()", returning = "returnValue")
    public void logAfterReturning(JoinPoint joinPoint, Object returnValue) {
        logger.info("method " + joinPoint.getSignature().toShortString() + " returned: " + returnValue);
    }
}
