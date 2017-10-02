package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createCustomer(Customer customer) {
        jdbcTemplate.update("INSERT INTO customer (firstname, lastname, phone, email) VALUES (?, ?, ?, ?)", customer.getFirstName(), customer.getLastName(), customer.getPhone(), customer.getEmail());
    }

    @Override
    public List<Customer> findCustomer(String search) {
        return jdbcTemplate.query("SELECT id, firstname, lastname, phone, email FROM customer WHERE (firstname = ? OR lastname = ? OR phone = ? OR email = ?) OR ? = '' ",
                (resultSet, i) -> new Customer(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("phone"), resultSet.getString("email")),
                search, search, search, search, search);
    }

    @Override
    public void updateCustomer(Customer customer) {
        jdbcTemplate.update("UPDATE customer SET firstname = ?, lastname = ?, phone = ?, email = ? WHERE id = ?)", customer.getFirstName(), customer.getLastName(), customer.getPhone(), customer.getEmail());
    }

    @Override
    public void deleteCustomer(Customer customer) {
        jdbcTemplate.update("DELETE FROM customer WHERE (firstname = ? OR lastname = ? OR phone = ? OR email = ?)", customer.getFirstName(), customer.getLastName(), customer.getPhone(), customer.getEmail());

    }
}
