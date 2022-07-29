package ru.germandilio.springcrm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.germandilio.springcrm.controllers.exceptions.CustomerNotFoundException;
import ru.germandilio.springcrm.controllers.exceptions.ServerResponse;
import ru.germandilio.springcrm.entity.Customer;
import ru.germandilio.springcrm.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerDAO(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {
        var customer = customerService.getCustomer(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with id " + id + " not found");
        }
        return customer;
    }

    @GetMapping("/customers/search/{name}")
    public List<Customer> searchCustomers(@PathVariable String name) {
        return customerService.searchCustomers(name);
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public ServerResponse deleteCustomer(@PathVariable int customerId) {
        if (customerService.getCustomer(customerId) == null) {
            throw new CustomerNotFoundException("Customer with id " + customerId + " not found");
        }

        customerService.deleteCustomer(customerId);
        return new ServerResponse(HttpStatus.OK.value(), "Customer with id " + customerId + " deleted", System.currentTimeMillis());
    }
}
