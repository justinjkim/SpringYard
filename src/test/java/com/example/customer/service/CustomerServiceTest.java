package com.example.customer.service;

import com.example.customer.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerServiceImpl;

    @Test
    public void findAllCustomersTest() {
        //arrange

        //act
        List<Customer> customers = customerServiceImpl.findCustomer("");

        //assert
        assertEquals(13, customers.size());

    }


}
