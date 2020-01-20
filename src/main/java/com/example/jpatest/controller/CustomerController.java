package com.example.jpatest.controller;

import com.example.jpatest.entity.Customer;
import com.example.jpatest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/")
    public @ResponseBody List<Customer> createCustomer(@RequestBody Map<String, String> param) {
        String name = param.get("name");
        String phone = param.get("phone");
        Customer customer = Customer.builder().name(name).phone(phone).build();
        customerRepository.save(customer);

        return customerRepository.findAll();
    }
}