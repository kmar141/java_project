package com.example.kieran.prison;

import java.util.ArrayList;

/**
 * Created by Kieran on 18/07/2017.
 */

public class Prison {
    private ArrayList<Cell> prison;
    private String name;


    public Prison(){
        prison = new ArrayList<Cell>();
    }

    public ArrayList<Cell> getCells(){
        return prison;
    }

    public void addCell(Cell cell) {
        prison.add(cell);
    }


    public int totalCells(){
        return this.prison.size();
    }


    public void removeCell(Cell cell1A) {
        prison.clear();
    }

    public int totalVisitors(){
        int counter = 0;
        for (Cell cell : prison){
           counter += cell.numberOfVisitors();
        }
        return counter;
    }
}
