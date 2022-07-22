package org.germandilio.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * Initially order of advices in one aspect execution isn't predefined.
 * To Solve this problem we can separate advices into different aspects.
 * Then add @Order annotation to aspects classes. Internally Spring will sort advices by this order.
 */
@Order(0)
//@Aspect
@Component
public class OrderingExecutionAspect {

    /**
     * Example of using pointcut from different package.
     */
    @Before("org.germandilio.aopdemo.aspects.LoggingAspect.forDaoPackage()")
    public void example() {
    }
}
