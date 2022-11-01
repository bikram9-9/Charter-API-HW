package com.charter.dto;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "transaction")
public class RetailTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private long id;

    private Double amount;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    //-------------------------
    public RetailTransaction(long id, Double amount, Date date, Customer customer) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.customer = customer;
    }

    public RetailTransaction() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
