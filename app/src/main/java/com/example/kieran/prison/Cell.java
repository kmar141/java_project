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
    private ArrayList<Prisoner> cell;


    public Cell(){
        this.cell = new ArrayList<Prisoner>();
    }

    public ArrayList<Prisoner> getCell(){
        return this.cell;
    }

    public int cellCount(){
        return this.cell.size();
    }

    public void addPrisoner(Prisoner prisoner) {
        if (!prisoner.isViolent()) {
            cell.add(prisoner);
                } else {
            if ((prisoner.isViolent()) && !containsViolentPrisoner()){
                cell.add(prisoner);

        }
    }

}

    public void emptyCell(){
        cell.clear();
    }

    public String getPrisonerName(){
        return cell.get(0).getName();
    }

//    public void save() {
//        String sql = String.format("INSERT INTO cells (prisoner_id) VALUES ('%d');",
//                this.prisoner_id);
//        this.id = SqlRunner.executeUpdate(sql);
//        SqlRunner.closeConnection();
//    }

    public static void deleteAll(){
        String sql = "DELETE FROM cells;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
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
}
