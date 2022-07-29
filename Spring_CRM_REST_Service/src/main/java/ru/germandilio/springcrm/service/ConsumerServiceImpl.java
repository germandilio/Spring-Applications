package ru.germandilio.springcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.germandilio.springcrm.dao.CustomerDAO;
import ru.germandilio.springcrm.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ConsumerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO;

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String searchName) {
        return customerDAO.searchCustomers(searchName);
    }
}
