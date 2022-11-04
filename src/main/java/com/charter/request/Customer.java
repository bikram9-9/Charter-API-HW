package com.charter.request;

import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

public class Customer {
    long customerId;
    String customerName;
    List<Transactions> transactions;

    public Customer(long customerId, String customerName, List<Transactions> transactions) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.transactions = transactions;
    }

    public Customer() {

    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }


}
