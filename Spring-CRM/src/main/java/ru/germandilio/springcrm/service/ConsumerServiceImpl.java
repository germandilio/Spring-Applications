package ru.germandilio.springcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.germandilio.springcrm.entity.Customer;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ConsumerServiceImpl implements CustomerService {
    private static final Logger logger = Logger.getLogger(ConsumerServiceImpl.class.getName());

    private RestTemplate restTemplate;
    private String customersRestUrl;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setCustomersRestUrl(@Value("${crm.api.customers.url}") String customersRestUrl) {
        this.customersRestUrl = customersRestUrl;
    }

    @Override
    public Customer getCustomer(int id) {
        var customers = restTemplate.exchange(customersRestUrl + "/" + id, HttpMethod.GET, null,
                Customer.class);

        logger.info("get customer - successfully");
        return customers.getBody();
    }

    @Override
    public void saveCustomer(Customer customer) {
        var savedCustomer = restTemplate.postForEntity(customersRestUrl, customer, String.class);
        logger.info("customer save - successfully: " + savedCustomer.getBody());
    }

    @Override
    public void updateCustomer(Customer customer) {
        restTemplate.put(customersRestUrl, customer);
        logger.info("customer update - successfully.");
    }

    @Override
    public void deleteCustomer(int id) {
        restTemplate.delete(customersRestUrl + "/" + id);
        logger.info("customer delete - successfully.");
    }

    @Override
    public List<Customer> getCustomers() {
        var customers = restTemplate.exchange(customersRestUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Customer>>() {});

        return customers.getBody();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        var customers = restTemplate.exchange(customersRestUrl + "/search/" + searchName, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Customer>>() {});

        logger.info("customer search - successfully.");
        return customers.getBody();
    }
}
