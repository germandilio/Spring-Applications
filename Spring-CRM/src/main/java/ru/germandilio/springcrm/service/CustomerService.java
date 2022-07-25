package ru.germandilio.springcrm.service;

import ru.germandilio.springcrm.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(int id);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);

    List<Customer> getCustomers();

    List<Customer> searchCustomers(String searchName);
}
