package com.example.kursachUD.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="CoffeeShopWorker")
public class CoffeeShopWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer coffeeShopWorkerId;


    private String coffeeShopWorkerName;
    private String coffeeShopWorkerPhoneNumber;
    private String coffeeShopWorkerEmail;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "coffee_shop_worker__id")
    private Collection<Zakaz> zakazs = new ArrayList<Zakaz>();


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

    public Collection<Zakaz> getZakazs() {
        return zakazs;
    }

    public void setZakazs(Collection<Zakaz> zakazs) {
        this.zakazs = zakazs;
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



