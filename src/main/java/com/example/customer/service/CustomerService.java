package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> findCustomer();
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Integer id);
}
