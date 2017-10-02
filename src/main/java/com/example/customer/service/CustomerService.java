package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> findCustomer(String find);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
