package com.example.kieran.prison;

import java.io.PipedReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import db.SqlRunner;

/**
 * Created by Kieran on 10/07/2017.
 */

public class Prisoner {
    private int id;
    private String name;
    private ArrayList<Food> belly = new ArrayList<Food>();
    private boolean violent;



    public Prisoner(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Prisoner(String name){
        this.name = name;
    }

    public Prisoner(String name, boolean violent){
        this.name = name;
        this.violent = violent;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void feedPrisoner(Food food){
        if (!isBellyFull()){
            belly.add(food);
        }
        prisonerRiotCheck();

    }

    public int foodCount(){
        return belly.size();
    }

    public boolean isBellyFull(){
        return (foodCount() >= 5);
    }

    public boolean isViolent() {
        return violent;
    }

    public int prisonerRiotCheck(){
        Random random = new Random();
        int bellyCount = foodCount();
        int riotChance = random.nextInt(foodCount());
        return riotChance;
    }









}
