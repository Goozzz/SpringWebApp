package com.example.kursachUD.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CoffeeShopWorker")
public class CoffeeShopWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "coffee_shop_worker_id")
    private Integer coffeeShopWorkerId;


    private String coffeeShopWorkerName;
    private String coffeeShopWorkerPhoneNumber;
    private String coffeeShopWorkerEmail;

    @OneToMany(mappedBy = "coffeeShopWorker", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderingInformation> orderingInformations = new HashSet<>();


    public CoffeeShopWorker() {
    }

    public CoffeeShopWorker(Integer id) {
        this.coffeeShopWorkerId = id;
    }

    public CoffeeShopWorker(String coffeeShopWorkerName, String coffeeShopWorkerPhoneNumber, String coffeeShopWorkerEmail) {
        this.coffeeShopWorkerName = coffeeShopWorkerName;
        this.coffeeShopWorkerPhoneNumber = coffeeShopWorkerPhoneNumber;
        this.coffeeShopWorkerEmail = coffeeShopWorkerEmail;
    }

    public Set<OrderingInformation> getOrderingInformations() {
        return orderingInformations;
    }

    public void setOrderingInformations(Set<OrderingInformation> orderingInformations) {
        this.orderingInformations = orderingInformations;
    }

    public Integer getCoffeeShopWorkerId() {
        return coffeeShopWorkerId;
    }

    public String getCoffeeShopWorkerName() {
        return coffeeShopWorkerName;
    }

    public void setCoffeeShopWorkerName(String coffeeShopWorkerName) {
        this.coffeeShopWorkerName = coffeeShopWorkerName;
    }

    public String getCoffeeShopWorkerPhoneNumber() {
        return coffeeShopWorkerPhoneNumber;
    }

    public void setCoffeeShopWorkerPhoneNumber(String coffeeShopWorkerPhoneNumber) {
        this.coffeeShopWorkerPhoneNumber = coffeeShopWorkerPhoneNumber;
    }

    public String getCoffeeShopWorkerEmail() {
        return coffeeShopWorkerEmail;
    }

    public void setCoffeeShopWorkerEmail(String coffeeShopWorkerEmail) {
        this.coffeeShopWorkerEmail = coffeeShopWorkerEmail;
    }

    public void setCoffeeShopWorkerId(Integer id) {
        this.coffeeShopWorkerId = id;
    }
}



