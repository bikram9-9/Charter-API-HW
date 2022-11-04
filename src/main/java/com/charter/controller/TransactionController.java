package com.charter.controller;

import com.charter.request.TransactionsRequest;
import com.charter.response.CustomerResponse;
import com.charter.service.TransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class TransactionController {

    private TransactionImpl transactionImpl;

    @Autowired
    public TransactionController(TransactionImpl transactionImpl){
        this.transactionImpl = transactionImpl;
    }

    @GetMapping("/getall")
    public ResponseEntity<TransactionsRequest> getAllTransactions(){
        ResponseEntity<TransactionsRequest> result = ResponseEntity.ok(transactionImpl.fillTransactionData());
        return result;
    }


    @GetMapping("/points")
    public ResponseEntity<List<CustomerResponse>> getAllPointsDetails(){
        return ResponseEntity.ok(transactionImpl.getAllPointsDetails());
    }
}
