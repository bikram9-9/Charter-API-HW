package com.charter.service;

import com.charter.dao.TransactionRepository;
import com.charter.dto.Customer;
import com.charter.dto.RetailTransaction;
import com.charter.response.CustomerResponse;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class TransactionImpl {
    private TransactionRepository transactionRepo;

    @Autowired
    public TransactionImpl(TransactionRepository transactionRepo){
        this.transactionRepo = transactionRepo;
    }

    //retrieve transactions last three months
    public List<RetailTransaction> getPreviousThreeMonths(){
        LocalDate now = LocalDate.now();
        int month = now.getMonth().getValue();
        return transactionRepo.getTransactionsAfter(month-3);
    }

    //calculate points of these transactions return list of Transactions, CustomerIds
    private List<CustomerResponse> getTotalPoints(List<RetailTransaction> transactions){
        List<CustomerResponse> list = new ArrayList<>();
        //Group By Months, Map of Customer_id, TotalInMonth
        CustomerResponse res = new CustomerResponse();
//        final double[] higherVal = {0.0};
               transactions.stream().map(t ->{
                    res.setFirstName(t.getCustomer().getFirstname());
                    res.setLastName(t.getCustomer().getLastName());
                    res.setMonth(t.getMonth());
//                    higherVal[0] = 0.04;
                    list.add(res);
                    return res;
                }
                );
        return list;
    }


    public RetailTransaction saveTransaction(RetailTransaction retailTransaction){
           return  transactionRepo.save(retailTransaction);
    }
}
