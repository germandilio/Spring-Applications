package org.germandilio.aopdemo;

import org.germandilio.aopdemo.dao.AccountDAO;
import org.germandilio.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(SpringConfig.class)) {
            var accountDAO = context.getBean("accountDAO", AccountDAO.class);

            accountDAO.withdrawFromAccount(100);
            accountDAO.withdrawFromAccount(-1);

            // custom business logic
//            accountDAO.addAccount("My Account");
//
//            var membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
//            membershipDAO.addAccount("My Account");
//            membershipDAO.addXP();
        }
    }
}
