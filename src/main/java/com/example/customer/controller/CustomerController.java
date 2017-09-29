package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {


    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String listAllCustomers(Model model) {
        model.addAttribute("customers", customerService.listAllCustomers());
        return "all-customers";
    }

    @GetMapping("/customerForm")
    public String customerForm(){
        return "customerForm";
    }

    @PostMapping("/create-customer")
    public String createCustomer(Customer customer){
        customerService.createCustomer(customer);
        return "redirect:/";
    }


}
