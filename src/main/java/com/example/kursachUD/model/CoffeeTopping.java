package com.example.kursachUD.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="coffee_topping")
public class CoffeeTopping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer coffeeToppingId;

    private String coffeeToppingDescription;

    @ManyToMany
    @JoinTable(name="coffee_and_topping",
            joinColumns=@JoinColumn (name="coffee_topping_id"),
            inverseJoinColumns=@JoinColumn(name="coffee_id"))
    private Set<Coffee> coffees = new HashSet<>();


    public CoffeeTopping() {
    }

    public CoffeeTopping(Integer coffeeToppingId) {
        this.coffeeToppingId = coffeeToppingId;
    }

    public CoffeeTopping(String coffeeToppingDescription) {
        this.coffeeToppingDescription = coffeeToppingDescription;
    }


    public Integer getCoffeeToppingId() {
        return coffeeToppingId;
    }

    public void setCoffeeToppingId(Integer coffeeToppingId) {
        this.coffeeToppingId = coffeeToppingId;
    }

    public String getDescriptionHarkt() {
        return coffeeToppingDescription;
    }

    public void setDescriptionHarkt(String harktDescription) {
        this.coffeeToppingDescription = harktDescription;
    }

    public Set<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(Set<Coffee> coffees) {
        this.coffees = coffees;
    }
}
