package com.charter.response;

import com.charter.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class CustomerResponse {

    private int month;
    private String firstName;
    private String lastName;
    private long monthPoints;
    private long totalPoints;

    public CustomerResponse(int month, String firstName, String lastName,long monthPoints, long totalPoints) {
        this.month = month;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPoints = totalPoints;
    }

    public CustomerResponse(){

    }
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getMonthPoints() {
        return monthPoints;
    }

    public void setMonthPoints(long monthPoints) {
        this.monthPoints = monthPoints;
    }

    public long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(long totalPoints) {
        this.totalPoints = totalPoints;
    }

}
