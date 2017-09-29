package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> listAllCustomers() {
        return customerRepository.listAllCustomers();
    }


    @Override
    public void createCustomer(Customer customer) {

    }


    @Override
    public void findCustomer(Customer customer) {

    }


    @Override
    public void updateCustomer(Customer customer) {

    }


    @Override
    public void deleteCustomer(Customer customer) {

    }
}
