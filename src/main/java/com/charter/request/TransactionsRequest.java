package com.charter.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.List;
public class TransactionsRequest {
    List<Customer> customer;

    public TransactionsRequest() {
    }

    public TransactionsRequest(List<Customer> customer){
        this.customer = customer;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}


