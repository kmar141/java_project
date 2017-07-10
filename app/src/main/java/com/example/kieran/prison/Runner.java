package com.example.kieran.prison;

/**
 * Created by Kieran on 10/07/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Prisoner.deleteAll();
        Cell.deleteAll();
        Prisoner prisoner = new Prisoner("Hulk");
        prisoner.save();
        Cell cell = new Cell(prisoner.getId());
        cell.save();
        System.out.println(cell.getPrisoner_id());

        Prisoner searchPrisoner = Prisoner.findPrisonerByName("Hulk");

        System.out.println(searchPrisoner.getName());






    }
}
