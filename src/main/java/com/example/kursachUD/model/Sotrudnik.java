package com.example.kursachUD.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="sotrudnik")
public class Sotrudnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sotrId;


    private String sotrName;
    private String sotrPhoneNumber;
    private String sotrEmail;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sotr_id")
    private Collection<Zakaz> zakazs = new ArrayList<Zakaz>();


    public Sotrudnik() {
    }

    public Sotrudnik(Integer id) {
        this.sotrId = id;
    }

    public Sotrudnik(String sotrName, String sotrPhoneNumber, String sotrEmail) {
        this.sotrName = sotrName;
        this.sotrPhoneNumber = sotrPhoneNumber;
        this.sotrEmail = sotrEmail;
    }

    public Collection<Zakaz> getZakazs() {
        return zakazs;
    }

    public void setZakazs(Collection<Zakaz> zakazs) {
        this.zakazs = zakazs;
    }

    public Integer getSotrId() {
        return sotrId;
    }

    public String getSotrName() {
        return sotrName;
    }

    public void setSotrName(String sotrName) {
        this.sotrName = sotrName;
    }

    public String getSotrPhoneNumber() {
        return sotrPhoneNumber;
    }

    public void setSotrPhoneNumber(String sotrPhoneNumber) {
        this.sotrPhoneNumber = sotrPhoneNumber;
    }

    public String getSotrEmail() {
        return sotrEmail;
    }

    public void setSotrEmail(String sotrEmail) {
        this.sotrEmail = sotrEmail;
    }

    public void setSotrId(Integer id) {
        this.sotrId = id;
    }
}



