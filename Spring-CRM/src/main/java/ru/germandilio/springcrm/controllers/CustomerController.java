package ru.germandilio.springcrm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.germandilio.springcrm.entity.Customer;
import ru.germandilio.springcrm.service.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerDAO(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/list")
    public ModelAndView listCustomers(@RequestParam("wasAdded") Optional<Boolean> wasAdded,
                                      @RequestParam("wasUpdated") Optional<Boolean> wasUpdated,
                                      @RequestParam("wasDeleted") Optional<Boolean> wasDeleted) {
        var modelAndView = new ModelAndView("customers/customer-list");

        // retrieve all customers if searchable collection is not present
        var customers = customerService.getCustomers();
        // add customer model
        modelAndView.addObject("customers", customers);

        wasAdded.ifPresent(param -> modelAndView.addObject("wasAdded", param));
        wasUpdated.ifPresent(param -> modelAndView.addObject("wasUpdated", param));
        wasDeleted.ifPresent(param -> modelAndView.addObject("wasDeleted", param));
        return modelAndView;
    }

    @GetMapping("/add-form")
    public ModelAndView showAddCustomerForm() {
        var modelAndView = new ModelAndView("customers/customer-add-form");

        Customer customer = new Customer();
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteCustomer(@RequestParam("customerId") int id) {
        customerService.deleteCustomer(id);

        // redirect to customers list
        var modelAndView = new ModelAndView("redirect:/customers/list");
        modelAndView.addObject("wasDeleted", true);
        return modelAndView;
    }

    @GetMapping("/edit-form")
    public ModelAndView showEditForm(@RequestParam("customerId") int id) {
        try {
            var customer = customerService.getCustomer(id);
            if (customer == null) {
                return showNotFound(id);
            }

            var modelAndView = new ModelAndView("customers/customer-edit-form");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } catch (Exception ex) {
            return showNotFound(id);
        }
    }

    private ModelAndView showNotFound(int id) {
        var errorView = new ModelAndView("customers/customer-not-found");
        errorView.addObject("customerId", id);
        return errorView;
    }

    @PostMapping("/search")
    public ModelAndView searchCustomers(@RequestParam("searchName") Optional<String> searchName) {
        if (searchName.isEmpty() || searchName.get().isBlank()) {
            return new ModelAndView("redirect:/customers/list");
        }

        var modelAndView = new ModelAndView("customers/customer-list");

        modelAndView.addObject("customers", customerService.searchCustomers(searchName.get()));
        return modelAndView;
    }

    @PostMapping("/confirm-add")
    public ModelAndView showAddConfirmationPage(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            var modelAndView = new ModelAndView("customers/customer-add-form");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }

        customerService.saveCustomer(customer);

        // redirect to customers list
        var modelAndView = new ModelAndView("redirect:/customers/list");
        modelAndView.addObject("wasAdded", true);
        return modelAndView;
    }

    @PostMapping("/confirm-update")
    public ModelAndView showUpdatedCustomersList(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            var modelAndView = new ModelAndView("customers/customer-edit-form");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }

        customerService.updateCustomer(customer);

        // redirect to customers list
        var modelAndView = new ModelAndView("redirect:/customers/list");
        modelAndView.addObject("wasUpdated", true);
        return modelAndView;
    }

    /**
     * Trim all string values in the customer form.
     *
     * @param dataBinder the data binder
     */
    @InitBinder
    public void initStringBinder(WebDataBinder dataBinder) {
        var trimmer = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, trimmer);
    }
}
