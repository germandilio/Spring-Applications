package ru.germandilio.thymeleaf_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.germandilio.thymeleaf_demo.entity.Customer;

import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersService {
    private RestTemplate crmRestServiceTemplate;

    @Value("${customers.rest.api.url}")
    private String url;

    @Autowired
    public void setCrmRestServiceTemplate(RestTemplate crmRestServiceTemplate) {
        this.crmRestServiceTemplate = crmRestServiceTemplate;
    }

    @Override
    public List<Customer> getCustomers() {
        var customers = crmRestServiceTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Customer>>() {});

        return customers.getBody();
    }

    @Override
    public Customer getCustomer(int id) {
        var customer = crmRestServiceTemplate.getForObject(url + "/" + id, Customer.class);
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        crmRestServiceTemplate.postForObject(url, customer, Customer.class);
    }

    @Override
    public void deleteCustomer(int id) {
        crmRestServiceTemplate.delete(url + "/" + id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        crmRestServiceTemplate.put(url, customer);
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        var customers = crmRestServiceTemplate.exchange(url + "/search/" + searchName, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Customer>>() {});
        return customers.getBody();
    }
}
