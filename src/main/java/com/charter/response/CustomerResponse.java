package com.charter.response;

import com.charter.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class CustomerResponse {

    private long id;
    private String firstName;
    private String lastName;
    private MonthlyPoints monthlyPoints;
    private long totalPoints;

    public CustomerResponse(long id, String firstName, String lastName, MonthlyPoints monthlyPoints, long totalPoints) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }

    public CustomerResponse(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public MonthlyPoints getMonthlyPoints() {
        return monthlyPoints;
    }

    public void setMonthlyPoints(MonthlyPoints monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    public long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(long totalPoints) {
        this.totalPoints = totalPoints;
    }


}
