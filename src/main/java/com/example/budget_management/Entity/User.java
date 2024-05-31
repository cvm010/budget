package com.example.budget_management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private int date;
    private int time;

    //that is if money is received or sent
    private String moneyFlow;

    // By default it should be none
    public String category;

}
