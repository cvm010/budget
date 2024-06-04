package com.example.budget_management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

//    public LocalDate date;
//    public LocalTime time;
    public String userName;
    public String date;
    public String time;



    private String payee;

    public int amount;

    //that is if money is received or sent
    public String moneyFlow;

    // By default it should be none
    public String category;

}
