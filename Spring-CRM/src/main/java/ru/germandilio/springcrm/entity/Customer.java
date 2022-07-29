package ru.germandilio.springcrm.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Customer {
    private int id;

    @NotNull(message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    private String email;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
