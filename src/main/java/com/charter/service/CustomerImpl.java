package com.charter.service;

import com.charter.dao.CustomerRepository;
import com.charter.dto.Customer;
import com.charter.dto.RetailTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerImpl {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> addRandomTwenty() {
        List<Customer> result = new ArrayList<>();
        int i = 0;
        while (i < 20) {
            result.add(customerRepository.save(new Customer((long) Math.random(), "Bikram", "Singh")));
            i++;
        }
        return result;
    }


}
