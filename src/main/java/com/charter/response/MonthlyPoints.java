package com.charter.response;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MonthlyPoints {

    // <Month, points>
    private HashMap<Integer,Integer> monthlyPoints = new HashMap<Integer, Integer>();

    public HashMap<Integer, Integer> getMonthlyPoints() {
        return monthlyPoints;
    }
    public MonthlyPoints(){

    }
    public void setMonthlyPoints(HashMap<Integer, Integer> monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    public MonthlyPoints(HashMap<Integer, Integer> monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }





}
