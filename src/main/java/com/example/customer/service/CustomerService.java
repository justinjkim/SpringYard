package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listAllCustomers();
    void createCustomer(Customer customer);
    List<Customer> findCustomer(String find);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
