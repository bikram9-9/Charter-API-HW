package com.charter.request;

import java.time.LocalDate;
import java.util.Date;

public class Transactions {

    Long transactionId;
    Double amount;
    LocalDate date;

    public Transactions(Long transactionId, Double amount, LocalDate date) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
    }

    public Transactions() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
