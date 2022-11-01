package com.charter.controller;

import com.charter.dao.CustomerRepository;
import com.charter.dto.Customer;

import com.charter.service.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private CustomerImpl customerImpl;

    @Autowired
    public CustomerController(CustomerImpl customerImpl){
        this.customerImpl = customerImpl;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerImpl.addCustomer(customer));
    }

    //create random 20 customer and save to database
    @PostMapping("/addRandom")
    public List<Customer> addRandomtwenty(){
        return customerImpl.addRandomTwenty();
        }
}
