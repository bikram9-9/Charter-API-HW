package com.charter.response;


public class CustomerResponse {

    private long id;
    private String customerName;
    private MonthlyPoints monthlyPoints;
    private long totalPoints;

    public CustomerResponse(long id, String customerName, MonthlyPoints monthlyPoints, long totalPoints) {
        this.id = id;
        this.customerName = customerName;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
