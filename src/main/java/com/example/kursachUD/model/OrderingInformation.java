package com.example.kursachUD.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class OrderingInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderingInformationId;
    private String orderingInformationName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usr user;

    @ManyToOne
    @JoinColumn(name = "coffee_shop_worker_id")
    private CoffeeShopWorker coffeeShopWorker;

    @ManyToMany
    @JoinTable (name="coffee_order",
            joinColumns=@JoinColumn (name="ordering_information_id"),
            inverseJoinColumns=@JoinColumn(name="coffee_id"))
    private Set<Coffee> coffees = new HashSet<>();

    public OrderingInformation() {
    }


    public OrderingInformation(Integer orderingInformationId) {
        this.orderingInformationId = orderingInformationId;
    }

    public OrderingInformation(String orderingInformationName) {
        this.orderingInformationName = orderingInformationName;
    }


    public Usr getUser() {
        return user;
    }

    public void setUser(Usr user) {
        this.user = user;
    }

    public CoffeeShopWorker getCoffeeShopWorker() {
        return coffeeShopWorker;
    }

    public void setCoffeeShopWorker(CoffeeShopWorker coffeeShopWorker) {
        this.coffeeShopWorker = coffeeShopWorker;
    }

    public Integer getOrderingInformationId() {
        return orderingInformationId;
    }

    public void setOrderingInformationId(Integer orderingInformationId) {
        this.orderingInformationId = orderingInformationId;
    }


    public String getOrderingInformationName() {
        return orderingInformationName;
    }

    public void setOrderingInformationName(String OrderingInformationName) {
        this.orderingInformationName = OrderingInformationName;
    }

    public Set<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(Set<Coffee> coffees) {
        this.coffees = coffees;
    }
}

