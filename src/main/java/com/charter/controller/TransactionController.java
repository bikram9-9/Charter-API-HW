package com.charter.controller;

import com.charter.dto.Customer;
import com.charter.dto.RetailTransaction;
import com.charter.service.TransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transaction;

@RestController
public class TransactionController {

    private TransactionImpl transactionImpl;

    @Autowired
    public TransactionController(TransactionImpl transactionImpl){
        this.transactionImpl = transactionImpl;
    }
    @GetMapping("/trans")
    public ResponseEntity<Transaction> getAllTransactions(){
        ResponseEntity result = ResponseEntity.ok(transactionImpl.getPreviousThreeMonths());
        return result;
    }

    @PostMapping("/trans")
    public ResponseEntity<RetailTransaction> createTransaction(@RequestBody RetailTransaction retailTransaction){
        return ResponseEntity.ok(transactionImpl.saveTransaction(retailTransaction));
    }
}
