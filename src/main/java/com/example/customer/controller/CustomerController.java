package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {


    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    @GetMapping("/")
//    public String listAllCustomers(Model model) {
//        model.addAttribute("customers", customerService.listAllCustomers());
//        return "all-customers";
//    }

    @GetMapping("/")
    public String findCustomer(Model model, @RequestParam(defaultValue = "") String find) {
        model.addAttribute("customers", customerService.findCustomer(find));
        model.addAttribute("find", find);
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

    @GetMapping("/deleteCustomerForm")
    public String deleteCustomerForm(){
        return "deleteCustomerForm";
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(Customer customer){
        customerService.deleteCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/updateCustomerForm")
    public String updateCustomerForm(){
        return "updateCustomerForm";
    }

    @PostMapping("/update-customer")
    public String updateCustomer(Customer customer){
        customerService.updateCustomer(customer);
        return "redirect:/";
    }


}
