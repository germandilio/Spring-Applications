package org.germandilio.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(String accountName) {
        System.out.println(getClass() + ": Account: " + accountName + " [DEBUG] Inside AccountDAO.addAccount() method");
    }


    public String withdrawFromAccount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative, provided: " + amount);
        }

        System.out.println(getClass() + ": [DEBUG] Inside AccountDAO.withdrawFromAccount() method --- withdrawing: " + amount);
        return "success";
    }
}
