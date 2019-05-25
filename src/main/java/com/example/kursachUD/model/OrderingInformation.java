package com.example.kursachUD.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
public class OrderingInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderingInformationId;
    private String orderingInformationName;

    @ManyToMany
    @JoinTable (name="coffee_order",
            joinColumns=@JoinColumn (name="ordering_information_id"),
            inverseJoinColumns=@JoinColumn(name="coffee_id"))
    private Collection<Coffee> coffees = new ArrayList<>();

    public OrderingInformation() {
    }


    public OrderingInformation(Integer orderingInformationId) {
        this.orderingInformationId = orderingInformationId;
    }

    public OrderingInformation(String orderingInformationName) {
        this.orderingInformationName = orderingInformationName;
    }

    public Integer getzakazId() {
        return orderingInformationId;
    }

    public Integer getOrderingInformationId() {
        return orderingInformationId;
    }

    public void setOrderingInformationId(Integer orderingInformationId) {
        this.orderingInformationId = orderingInformationId;
    }

    public void setzakazId(Integer zakazId) {
        this.orderingInformationId = zakazId;
    }

    public String getzakazName() {
        return orderingInformationName;
    }

    public void setzakazName(String zakazName) {
        this.orderingInformationName = zakazName;
    }

    public Collection<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(Collection<Coffee> coffees) {
        this.coffees = coffees;
    }
}

