package com.example.kieran.prison;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.StringJoiner;

import db.SqlRunner;

import static android.R.attr.id;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by Kieran on 10/07/2017.
 */

public class Cell {
    public ArrayList<Prisoner> cell;
    public boolean solitary;
    public ArrayList<Visitor> visitors;


    public Cell(){
        this.cell = new ArrayList<Prisoner>();
        this.visitors = new ArrayList<Visitor>();
    }



    public Cell(boolean solitary){
        this.cell = new ArrayList<Prisoner>();
        this.visitors = new ArrayList<Visitor>();
        this.solitary = solitary;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public ArrayList<Prisoner> getCell(){
        return this.cell;
    }

    public int cellCount(){
        return this.cell.size();
    }

    public void addPrisoner(Prisoner prisoner){
        if (!prisoner.isViolent()) {
            cell.add(prisoner);
                } else {
            if ((prisoner.isViolent()) && !containsViolentPrisoner()){
                cell.add(prisoner);

            }
        }

    }

    public void addVisitor(Visitor visitor){
        if (solitary == false){
            visitors.add(visitor);
        }
    }

    public void emptyCell(){
        cell.clear();
    }



    public String getPrisonerName(){
        return cell.get(0).getName();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getPrisonerNames() {
        StringJoiner prisoner_names = new StringJoiner(", ");
        for (Prisoner prisoner : cell) {

            prisoner_names.add(prisoner.getName());
        }
        return prisoner_names.toString();
    }


    public boolean containsViolentPrisoner() {
        for (Prisoner prisoner : cell) {
            if (prisoner.isViolent()) {
                return true;

            }
        }
        return false;
    }

    public boolean isSolitary() {
        return solitary;
    }

    public int numberOfVisitors() {
        return visitors.size();
    }

    public void prisonerRiot(Prisoner prisoner){
        if (prisoner.prisonerRiotCheck() < 2){
            cell.remove(1);
        }

    }
}
