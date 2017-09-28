package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> listAllCustomers() {
        return jdbcTemplate.query(
                //"SELECT firstname, lastname FROM person WHERE firstname = '"  + search + "' LIMIT 100", <--- don't!!!
                "SELECT firstname, lastname, phone, email FROM customer",
                (resultSet, i) -> new Customer(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("phone"), resultSet.getString("email")));
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
