package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    void createCustomer(Customer customer);
    List<Customer> findCustomer(String search);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
