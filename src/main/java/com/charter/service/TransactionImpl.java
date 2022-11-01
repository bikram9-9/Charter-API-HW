package com.charter.service;

import com.charter.dao.TransactionRepository;
import com.charter.dto.Customer;
import com.charter.dto.RetailTransaction;
import com.charter.response.CustomerResponse;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Service
public class TransactionImpl {
    private TransactionRepository transactionRepo;

    @Autowired
    public TransactionImpl(TransactionRepository transactionRepo){
        this.transactionRepo = transactionRepo;
    }

    //retrieve transactions last three months
    public List<Transaction> getPreviousThreeMonths(){
        LocalDate now = LocalDate.now();
        LocalDate threeMonthsAgo = now.minusMonths(3);
        Date date = Date.valueOf(threeMonthsAgo);
        return transactionRepo.getTransactionsAfter(date);
    }

    //calculate points of these transactions return list of Transactions, CustomerIds
    private List<CustomerResponse> getTotalPoints(List<Transaction> transactions){
        List<CustomerResponse> list = new ArrayList<>();
        transactions.forEach( t -> {
        });
        return list;
    }


    public RetailTransaction saveTransaction(RetailTransaction retailTransaction){
           return  transactionRepo.save(retailTransaction);
    }
}
