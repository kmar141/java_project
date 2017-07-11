package com.example.kieran.prison;

import java.io.PipedReader;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.SqlRunner;

/**
 * Created by Kieran on 10/07/2017.
 */

public class Prisoner {
    private int id;
    private String name;
    private ArrayList<Food> belly = new ArrayList<Food>();

    public Prisoner(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Prisoner(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void deleteByID(){
        String sql = String.format("DELETE FROM prisoners WHERE id = d%;", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void deleteByName(String name){
        String sql = String.format("DELETE FROM prisoners WHERE name = '%s';", name);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }



    public void save() {
        String sql = String.format("INSERT INTO prisoners (name) VALUES ('%s');", this.name);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static Prisoner findPrisonerByName(String name){
        Prisoner prisoner = null;
        String sql = String.format("SELECT * FROM prisoners WHERE name = '%s';", name);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while(rs.next()){
                int id = rs.getInt("id");
                String nameOfPrisoner = rs.getString("name");
                prisoner = new Prisoner(nameOfPrisoner);
            }
        } catch (Exception ex){
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
        return prisoner;
    }

    public static void deleteAll(){
        String sql = "DELETE FROM prisoners;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void feedPrisoner(Food food){
        if (!isBellyFull()){
            belly.add(food);
        }
    }

    public int foodCount(){
        return belly.size();
    }

    public boolean isBellyFull(){
        return (foodCount() >= 5);
    }


}
