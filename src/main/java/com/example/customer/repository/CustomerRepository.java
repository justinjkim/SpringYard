package com.example.customer.repository;

import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> listAllCustomers();
    void createCustomer(Customer customer);
    void findCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
