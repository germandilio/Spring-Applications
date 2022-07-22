package org.germandilio.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class CombinePointcutsDemoAspect {

    @Pointcut("execution(* org.germandilio.aopdemo.dao.AccountDAO.*(..))")
    public void forAccountDaoPackage() {}

    @Pointcut("execution(* org.germandilio.aopdemo.dao.MembershipDAO.*(..))")
    public void forMembershipDaoPackage() {}

    @Pointcut("forAccountDaoPackage() || forMembershipDaoPackage()")
    public void disjunctionPointCut() {}

    @Pointcut("forAccountDaoPackage() && forMembershipDaoPackage()")
    public void conjanctionPointCut() {}

    @Pointcut("!forAccountDaoPackage()")
    public void negotiationPointCut() {}

    @Pointcut("!(forAccountDaoPackage() && !(forAccountDaoPackage() || forMembershipDaoPackage()))")
    public void frankinshtain() {}
}
