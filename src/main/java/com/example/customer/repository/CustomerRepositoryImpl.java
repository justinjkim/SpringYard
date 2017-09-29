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
                "SELECT firstname, lastname, phone, email FROM customer",
                (resultSet, i) -> new Customer(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("phone"), resultSet.getString("email")));
    }

    @Override
    public void createCustomer(Customer customer) {
        jdbcTemplate.update("INSERT INTO customer (firstname, lastname, phone, email) VALUES (?, ?, ?, ?)", customer.getFirstName(), customer.getLastName(), customer.getPhone(), customer.getEmail());
    }

    @Override
    public List<Customer> findCustomer(String search) {
        return jdbcTemplate.query("SELECT firstname, lastname, phone, email FROM customer WHERE (firstname = ? OR lastname = ? OR phone = ? OR email = ?) OR ? = ''  LIMIT 50",
                (resultSet, i) -> new Customer(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("phone"), resultSet.getString("email")),
                search, search, search, search);
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Customer customer) {
        jdbcTemplate.query("DELETE FROM customer WHERE (firstname = ? OR lastname = ? OR phone = ? OR email = ?)");
    }
}
