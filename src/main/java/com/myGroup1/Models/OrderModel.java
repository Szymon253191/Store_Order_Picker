package com.myGroup1.Models;

import java.time.Duration;
import java.time.LocalTime;

public class OrderModel {
    private final String orderId;
    private final double orderValue;
    private final String pickingTime;
    private final LocalTime completeBy;
    private final LocalTime latestStartTime;
    private final double importance;

    public OrderModel(String orderId, double orderValue, String pickingTime, LocalTime completeBy) {
        this.orderId = orderId;
        this.orderValue = orderValue;
        this.pickingTime = pickingTime;
        this.completeBy = completeBy;
        this.latestStartTime = getLatestStartTime();
        this.importance = getOrderValue()/getPickingTime().toMinutes();
    }

    public String getOrderId() {
        return orderId;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public Duration getPickingTime() {
        return Duration.parse(this.pickingTime);
    }

    public LocalTime getCompleteBy() {
        return completeBy;
    }

    public LocalTime getLatestStartTime() {
        Duration duration = Duration.parse(this.pickingTime);
        LocalTime time = this.completeBy.minus(duration);
        return time;
    }
    public double getImportance() {
        return importance;
    }

    public void printAllOrderInfo() {
//        System.out.printf(orderId+"\t|\t"+orderValue+"\t|\t"+pickingTime+"\t|\t"+completeBy+"\t|\t"+importance);
        System.out.printf("%s \t %02.1f \t %s \t%s \t%02.2f\n",orderId.toString(),orderValue,pickingTime.toString(),completeBy.toString(),importance);
    }
}