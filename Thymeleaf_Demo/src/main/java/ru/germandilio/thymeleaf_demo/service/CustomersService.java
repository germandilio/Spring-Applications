package ru.germandilio.thymeleaf_demo.service;

import ru.germandilio.thymeleaf_demo.entity.Customer;

import java.util.List;

public interface CustomersService {
    List<Customer> getCustomers();

    Customer getCustomer(int id);

    void saveCustomer(Customer customer);

    void deleteCustomer(int id);

    void updateCustomer(Customer customer);

    List<Customer> searchCustomers(String searchName);
}
