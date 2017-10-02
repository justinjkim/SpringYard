package com.example.customer.repository;

import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    void createCustomer(Customer customer);
    List<Customer> findCustomer(String search);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
