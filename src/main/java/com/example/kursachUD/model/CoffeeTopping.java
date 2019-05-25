package com.example.kursachUD.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

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
    private Collection<Coffee> coffees = new ArrayList<>();


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

    public Collection<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(Collection<Coffee> coffees) {
        this.coffees = coffees;
    }
}
