package org.germandilio.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingInDifferentTimeDemoAspect {
    private static Logger logger = Logger.getLogger(LoggingInDifferentTimeDemoAspect.class.getName());

    @Before(value = "execution(public * org.germandilio.aopdemo.dao.AccountDAO.withdrawFromAccount(int))")
    public void logBefore(JoinPoint jointPoint) {
        logger.info("before withdrawal");
        logger.info("jointPoint.getSignature().toShortString() = " + jointPoint.getSignature().toShortString());

    }

    @After("execution(public * org.germandilio.aopdemo.dao.AccountDAO.withdrawFromAccount(int))")
    public void logAfterFinally() {
        logger.info("after withdrawal (finally)");
    }

    @AfterReturning(pointcut = "execution(public * org.germandilio.aopdemo.dao.AccountDAO.withdrawFromAccount(int))",
            returning = "result")
    public void logAfterSuccessExecution(JoinPoint joinPoint, String result) {
        logger.info("after withdrawal [" + result.toUpperCase(Locale.ROOT) + "]");
    }

    @AfterThrowing(pointcut = "execution(public * org.germandilio.aopdemo.dao.AccountDAO.withdrawFromAccount(int))",
    throwing = "throwable")
    public void logAfterThrowingException(JoinPoint point,
                                          Throwable throwable) {
        logger.info("after withdrawal [EXCEPTION]");
    }

    @Around("execution(public * org.germandilio.aopdemo.dao.AccountDAO.withdrawFromAccount(int))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("@Around");
        long beginTime = System.currentTimeMillis();

        try {
            return pjp.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long durationTime = endTime - beginTime;
            logger.info("Running in " + durationTime + " ms");
        }
    }
}
