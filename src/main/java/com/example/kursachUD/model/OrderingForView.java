package com.example.kursachUD.model;

import java.util.Set;

public class OrderingForView {

    private Integer orderId;
    private String orderDescription;
    private String userName;
    private String workerName;
    private Set<Coffee> coffeeSet;


    public OrderingForView(Integer orderId, String orderDescription, String userName, String workerName, Set<Coffee> coffeeSet) {
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.userName = userName;
        this.workerName = workerName;
        this.coffeeSet = coffeeSet;
    }
}
