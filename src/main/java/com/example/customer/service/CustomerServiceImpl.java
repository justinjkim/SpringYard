package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    @Override
    public List<Customer> listAllCustomers() {
        return null;
    }

    @Transactional
    @Override
    public void createCustomer(Customer customer) {

    }

    @Transactional
    @Override
    public void findCustomer(Customer customer) {

    }

    @Transactional
    @Override
    public void updateCustomer(Customer customer) {

    }

    @Transactional
    @Override
    public void deleteCustomer(Customer customer) {

    }
}
