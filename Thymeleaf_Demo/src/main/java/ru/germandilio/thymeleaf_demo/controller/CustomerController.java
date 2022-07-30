package ru.germandilio.thymeleaf_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.germandilio.thymeleaf_demo.service.CustomersService;


@Controller
@RequestMapping("/customers")
public class CustomerController {
    private CustomersService customersService;

    @Autowired
    public void setCustomersService(CustomersService customersService) {
        this.customersService = customersService;
    }


    @GetMapping("/list")
    public ModelAndView listCustomers() {
        var modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customersService.getCustomers());
        return modelAndView;
    }
}
