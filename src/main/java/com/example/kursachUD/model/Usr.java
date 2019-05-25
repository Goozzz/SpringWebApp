package com.example.kursachUD.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr")
public class Usr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderingInformation> orderingInformations = new HashSet<OrderingInformation>();

    private String userName;
    private String userEmail;



    public Usr() {
    }

    public Usr(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Usr(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Set<OrderingInformation> getOrderingInformations() {
        return orderingInformations;
    }

    public void setOrderingInformations(Set<OrderingInformation> orderingInformations) {
        this.orderingInformations = orderingInformations;
    }
}
