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
    @JoinTable (name="coffee_order",
            joinColumns=@JoinColumn (name="coffee_id"),
            inverseJoinColumns=@JoinColumn(name="ordering_information_id"))
    private Collection<OrderingInformation> orderingInformations = new ArrayList<>();

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

    public Collection<OrderingInformation> getOrderingInformations() {
        return this.orderingInformations;
    }

    public void setOrderingInformations(Collection<OrderingInformation> orderingInformations) {
        this.orderingInformations = orderingInformations;
    }

    public Collection<CoffeeTopping> getCoffeeToppings() {
        return coffeeToppings;
    }

    public void setCoffeeToppings(Collection<CoffeeTopping> coffeeToppings) {
        this.coffeeToppings = coffeeToppings;
    }
}
