package com.charter.service;

import com.charter.dao.TransactionRepository;
import com.charter.dto.Customer;
import com.charter.dto.RetailTransaction;
import com.charter.response.CustomerResponse;
import com.charter.response.MonthlyPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TransactionImpl {
    private TransactionRepository transactionRepo;

    @Autowired
    public TransactionImpl(TransactionRepository transactionRepo){
        this.transactionRepo = transactionRepo;
    }


    public List<CustomerResponse> getAllPointsDetails(){
        CustomerResponse customerResponse = new CustomerResponse();
        List<RetailTransaction> transactionsThreeMonths = getPreviousThreeMonths();

        MonthlyPoints monthlyPoints = calcMontlyPoints(transactionsThreeMonths);
        int totalPoints = calcTotalPoints(monthlyPoints);

        //need a list of all the transactions for that customer
        //while the customer

    }

    //retrieve transactions last three months
    public List<RetailTransaction> getPreviousThreeMonths(){
        LocalDate now = LocalDate.now();
        int month = now.getMonth().getValue();
        return transactionRepo.getTransactionsAfter(month-3);
    }

    // result is <month, points> - 1: 20points, 3: 40points
    public MonthlyPoints calcMontlyPoints(List<RetailTransaction> list){
        HashMap<Integer,Integer> mp = new HashMap<Integer, Integer>();
        MonthlyPoints monthlyPoints = new MonthlyPoints();
        int currMonthPoints = 0;
        double amount = 0.0;
        for(int i =0;i< list.size()-1;i++){
            while(list.get(i).getMonth() == list.get(i+1).getMonth()){
                 amount = list.get(i).getAmount();
                currMonthPoints += (int)calcPoints(amount);
            }
            //map <Month,totalMonthPoints>
            mp.put(list.get(i).getMonth(),currMonthPoints);
        }
        monthlyPoints.setMonthlyPoints(mp);
        return monthlyPoints;
    }

    private int calcPoints(double amount){
        int points = 0;
        if(amount > 100.0) {
            points = (int)((amount-100.0)*2) + 50;
        }else {
            points = (int)(amount - 50.0);
        }

        return points;
    }


    private int calcTotalPoints(MonthlyPoints monthlyPoints){
        int sum = 0;
        for(Map.Entry<Integer,Integer> mp :  monthlyPoints.getMonthlyPoints().entrySet()){
                int points = mp.getValue();
                sum += points;
        }
        return sum;
    }


    public RetailTransaction saveTransaction(RetailTransaction retailTransaction){
           return  transactionRepo.save(retailTransaction);
    }
}
