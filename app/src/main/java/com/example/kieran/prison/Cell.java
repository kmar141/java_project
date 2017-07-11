package com.example.kieran.prison;

import java.sql.PreparedStatement;

import db.SqlRunner;

/**
 * Created by Kieran on 10/07/2017.
 */

public class Cell {
    private int id;
    private int prisoner_id;


    public Cell(int prisoner_id){
        this.prisoner_id = prisoner_id;
    }

    public int getId() {
        return id;
    }

    public int getPrisoner_id() {
        return prisoner_id;
    }

    public void save() {
        String sql = String.format("INSERT INTO cells (prisoner_id) VALUES ('%d');",
                this.prisoner_id);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void deleteAll(){
        String sql = "DELETE FROM cells;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

}
