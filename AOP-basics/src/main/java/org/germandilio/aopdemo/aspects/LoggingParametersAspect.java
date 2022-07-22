package org.germandilio.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Aspect
@Component
public class LoggingParametersAspect {

    @Before("execution(* org.germandilio.aopdemo.dao.*.*(..))")
    public void retrieveParameters(JoinPoint joinPoint) {
        System.out.println("joinPoint.getSignature() = " + joinPoint.getSignature());
        System.out.println("joinPoint.getArgs() = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("joinPoint.getTarget() = " + joinPoint.getTarget());
        System.out.println("joinPoint.getThis() = " + joinPoint.getThis());
    }
}
