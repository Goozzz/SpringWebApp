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
    @JoinTable(name="coffee_and_topping",
            joinColumns=@JoinColumn (name="coffee_id"),
            inverseJoinColumns=@JoinColumn(name="coffee_topping_id"))
    private Collection<CoffeeTopping> coffeeToppings = new ArrayList<>();

    private String coffeeName;
    private Integer coffeePrice;

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

    public Coffee(String coffeeName, Integer coffeePrice) {
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public Integer getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(Integer coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    public Collection<Zakaz> getZakazs() {
        return this.zakazs;
    }

    public void setZakazs(Collection<Zakaz> zakazs) {
        this.zakazs = zakazs;
    }

    public Collection<CoffeeTopping> getCoffeeToppings() {
        return coffeeToppings;
    }

    public void setCoffeeToppings(Collection<CoffeeTopping> coffeeToppings) {
        this.coffeeToppings = coffeeToppings;
    }
}
