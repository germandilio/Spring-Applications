package org.germandilio.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount(String accountName) {
        System.out.println(getClass() + ": Account: " + accountName + " [DEBUG] Inside MembershipDAO.addAccount(String) method");
    }

    public String addXP() {
        System.out.println(getClass() + ": [DEBUG] Inside MembershipDAO.addXP() method");
        return null;
    }
}
