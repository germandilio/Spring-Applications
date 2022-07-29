package ru.germandilio.springcrm.dao;

import ru.germandilio.springcrm.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    Customer getCustomer(int id);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);

    List<Customer> getCustomers();

    List<Customer> searchCustomers(String searchName);
}
