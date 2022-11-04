package com.charter.service;
import com.charter.request.Customer;
import com.charter.request.Transactions;
import com.charter.request.TransactionsRequest;
import com.charter.response.CustomerResponse;
import com.charter.response.MonthlyPoints;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionImpl {

    // add data to the objects
    public TransactionsRequest fillTransactionData(){
        List<Transactions> transactions1 =  new ArrayList<>();
        transactions1.add(new Transactions((long)123,140.0,LocalDate.of(2022, Month.JANUARY,3)));
        transactions1.add(new Transactions((long)134,120.0,LocalDate.of(2022, Month.OCTOBER,21)));
        transactions1.add(new Transactions((long)156,220.0,LocalDate.of(2022, Month.NOVEMBER,12)));
        transactions1.add(new Transactions((long)198,30.0,LocalDate.of(2022, Month.OCTOBER,2)));

        List<Transactions> transactions2 =  new ArrayList<Transactions>();
        transactions2.add(new Transactions((long)123,150.0,LocalDate.of(2022, Month.FEBRUARY,14)));
        transactions2.add(new Transactions((long)134,90.0,LocalDate.of(2022, Month.SEPTEMBER,22)));
        transactions2.add(new Transactions((long)156,80.0,LocalDate.of(2022, Month.AUGUST,2)));
        transactions2.add(new Transactions((long)198,230.0,LocalDate.of(2022, Month.NOVEMBER,3)));

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(343,"Bikram Singh", transactions1));
        customers.add(new Customer(33,"John Dave", transactions2));
        TransactionsRequest tr = new TransactionsRequest();
        tr.setCustomer(customers);
        return tr;
    }

        public List<CustomerResponse> getAllPointsDetails(){
        TransactionsRequest request = fillTransactionData();
        List<CustomerResponse> result  = new ArrayList<>();
        List<Customer> customers = request.getCustomer();
            for(Customer c : customers){
                CustomerResponse customerResponse = new CustomerResponse();
                customerResponse.setId(c.getCustomerId());
                customerResponse.setCustomerName(c.getCustomerName());
                customerResponse.setMonthlyPoints(calcMonthlyPoints(c.getTransactions()));
                customerResponse.setTotalPoints(calcTotalPoints(c.getTransactions()));
                result.add(customerResponse);
            };
             return result;
         }

    private MonthlyPoints calcMonthlyPoints(List<Transactions> transactions){
        MonthlyPoints mp = new MonthlyPoints();
        HashMap<Integer,Integer> map = new HashMap<>();
        //for each month add the amount to the map if it contains that value
            for(Transactions t: transactions){
                if(map.containsKey(t.getDate().getMonthValue())){
                    int amount = map.get(t.getDate().getMonthValue());
                    amount += calcPoints(t.getAmount());
                    map.put(t.getDate().getMonthValue(),amount);
                }else {
                    map.put(t.getDate().getMonthValue(),calcPoints(t.getAmount()));
                }
            }
        mp.setMonthlyPoints(map);
        return mp;
    }

    private int calcPoints(double amount){
        int points = 0;
        if(amount >= 100.0) {
            points = (int)((amount-100.0)*2) + 50;
        }else if(amount >=50 ) {
            points = (int)(amount - 50.0);
        }

        return points;
    }

    private int calcTotalPoints(List<Transactions> transactions){
        double sum = 0;
        for(Transactions t: transactions){
            sum += calcPoints(t.getAmount());
        }
        return (int)sum;
    }

}
