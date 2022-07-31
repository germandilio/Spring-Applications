package ru.germandilio.thymeleaf_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.germandilio.thymeleaf_demo.entity.Customer;
import ru.germandilio.thymeleaf_demo.service.CustomersService;

import java.util.Comparator;
import java.util.Optional;


@Controller
@RequestMapping("/customers")
public class CustomerController {
    private CustomersService customersService;

    @Autowired
    public void setCustomersService(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/list")
    public ModelAndView listCustomers(@RequestParam Optional<Boolean> wasAdded,
                                      @RequestParam Optional<Boolean> wasDeleted,
                                      @RequestParam Optional<Boolean> wasUpdated) {
        var modelAndView = new ModelAndView("customer/list");
        var customers = customersService.getCustomers()
                .stream()
                .sorted(Comparator.comparing(Customer::getLastName))
                .toList();

        modelAndView.addObject("customers", customers);

        wasAdded.ifPresent(aBoolean -> modelAndView.addObject("wasAdded", aBoolean));
        wasDeleted.ifPresent(aBoolean -> modelAndView.addObject("wasDeleted", aBoolean));
        wasUpdated.ifPresent(aBoolean -> modelAndView.addObject("wasUpdated", aBoolean));
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddForm() {
        var modelAndView = new ModelAndView("customer/add-form");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/confirm-add")
    public ModelAndView addCustomer(@ModelAttribute("customer") Customer customer) {
        customersService.saveCustomer(customer);
        return new ModelAndView("redirect:/customers/list?wasAdded=true");
    }

    @GetMapping("/edit")
    public ModelAndView showEditCustomerForm(@RequestParam("id") int id) {
        var modelAndView = new ModelAndView("customer/edit-form");
        var customer = customersService.getCustomer(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/confirm-edit")
    public ModelAndView editCustomer(@ModelAttribute("customer") Customer customer) {
        customersService.updateCustomer(customer);
        return new ModelAndView("redirect:/customers/list?wasUpdated=true");
    }

    @GetMapping("/delete")
    public ModelAndView deleteCustomer(@RequestParam("id") int id) {
        customersService.deleteCustomer(id);
        return new ModelAndView("redirect:/customers/list?wasDeleted=true");
    }

    @GetMapping("/search")
    public ModelAndView searchCustomers(@RequestParam("searchName") String name) {
        var customers = customersService.searchCustomers(name).stream()
                .sorted(Comparator.comparing(Customer::getLastName))
                .toList();

        var modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
