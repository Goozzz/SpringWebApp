package com.example.kursachUD.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "coffee")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer coffeeId;

    @ManyToMany
    @JoinTable (name="zakaz_tovar",
            joinColumns=@JoinColumn (name="coffee_id"),
            inverseJoinColumns=@JoinColumn(name="zakaz_id"))
    private Collection<Zakaz> zakazs = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="tovar_harakteristik",
            joinColumns=@JoinColumn (name="coffee_id"),
            inverseJoinColumns=@JoinColumn(name="harakteristiki_id"))
    private Collection<Harakteristiki> harakteristiks = new ArrayList<>();

    private String coffeeName;
    private String coffeePrice;

    public Coffee() { }

    public void setCoffeeId(Integer coffeeId) {
        this.coffeeId = coffeeId;
    }

    public Coffee(Integer coffeeId) {
        this.coffeeId = coffeeId;
    }

    public Integer getCoffeeId() {
        return coffeeId;
    }

    public Coffee(String coffeeName, String coffeePrice) {
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(String coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    public Collection<Zakaz> getZakazs() {
        return this.zakazs;
    }

    public void setZakazs(Collection<Zakaz> zakazs) {
        this.zakazs = zakazs;
    }

    public Collection<Harakteristiki> getHarakteristiks() {
        return harakteristiks;
    }

    public void setHarakteristiks(Collection<Harakteristiki> harakteristiks) {
        this.harakteristiks = harakteristiks;
    }
}
