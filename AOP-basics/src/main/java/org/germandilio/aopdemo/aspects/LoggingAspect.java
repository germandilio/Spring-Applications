package org.germandilio.aopdemo.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
//@Aspect
@Component
public class LoggingAspect {
    /**
     * Will be executed before the execution of the 'public void addAccount(String, ..)' method in the AccountDAO class.
     */
    @Before("execution(public void org.germandilio.aopdemo.dao.AccountDAO.addAccount(String, ..))")
    public void logBeforeAspect() {
        System.out.println("==> [DEBUG] Executing before AccountDAO.addAccount() method");
    }

    /**
     * Will be executed before all MembershipDAo methods witch stats from 'add' name
     */
    @Before("execution(* org.germandilio.aopdemo.dao.MembershipDAO.add*(..))")
    public void logBeforeMembershipAspect() {
        System.out.println("==> [DEBUG] Executing before * MembershipDAO.add*() methods");
    }

    @After("execution(* org.germandilio.aopdemo.dao.*.*(..))")
    public void logAfterAllMethodsInPackage() {
        System.out.println("==> [DEBUG] Executing after all methods in org.germandilio.aopdemo.dao package");
    }

    /**
     * Declaration of reusable pointcut.
     */
    @Pointcut("execution(* org.germandilio.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // imagine we need transaction security and logging for the same method group

    @Before("forDaoPackage()")
    public void logBeforeDaoPackage() {
        System.out.println("from logBeforeDaoPackage");
    }

    @Before("forDaoPackage()")
    public void transactionBeforeDaoPackage() {
        System.out.println("from transactionBeforeDaoPackage");
    }

    @Before("forDaoPackage()")
    public void securityChecksBeforeDaoPackage() {
        System.out.println("from securityChecksBeforeDaoPackage");
    }
}
