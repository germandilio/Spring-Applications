package ru.germandilio.thymeleaf_demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
