package com.example.kieran.prison;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Kieran on 11/07/2017.
 */

public class CellTest {

    Prisoner prisoner;
    Prisoner prisoner2;
    Prisoner prisoner3;
    Prisoner violentPrisoner1;
    Prisoner violentPrisoner2;
    Cell cell;
    Cell solitary;
    Visitor visitor;
    Prison wandsworth;

    @Before
    public void before(){
        prisoner = new Prisoner("Rick");
        prisoner2 = new Prisoner("Morty");
        prisoner3 = new Prisoner("Jerry");
        violentPrisoner1 = new Prisoner("Bebop", true);
        violentPrisoner2 = new Prisoner("Rocksteady", true);
        cell = new Cell(false);
        solitary = new Cell(true);
        visitor = new Visitor();
        wandsworth = new Prison();

    }

    @Test
    public void testCell() throws Exception {
        assertNotNull(cell);
    }



    @Test
    public void testCellClear() throws Exception {
        cell.addPrisoner(prisoner);
        cell.emptyCell();
        assertEquals(0, cell.cellCount());

    }


    @Test
    public void testAddThreePrisoners() throws Exception {
        cell.addPrisoner(prisoner);
        cell.addPrisoner(prisoner2);
        cell.addPrisoner(prisoner3);
        assertEquals(3, cell.cellCount());

    }


    @Test
    public void testDontAddViolentPrisoner() throws Exception {
        cell.addPrisoner(violentPrisoner1);
        assertEquals(1, cell.cellCount());
        cell.addPrisoner(violentPrisoner2);
        assertEquals(1, cell.cellCount());
        cell.addPrisoner(prisoner);
        assertEquals(2, cell.cellCount());
    }


    @Test
    public void testCellContainsViolentPrisoner_true() throws Exception {
        cell.addPrisoner(violentPrisoner1);
        assertTrue(cell.containsViolentPrisoner());
    }

    @Test
    public void testCellContainsViolentPrisoner_false() throws Exception {
        cell.addPrisoner(prisoner);
        assertFalse(cell.containsViolentPrisoner());

    }

    @Test
    public void testCellIsSolitary() throws Exception {
        assertTrue(solitary.isSolitary());

    }

    @Test
    public void testPrisonerCanHaveVisitor() throws Exception {
        cell.addVisitor(visitor);
        assertEquals(1, cell.numberOfVisitors());

    }

//    @Test
//    public void testPrisonerCantHaveVisitor() throws Exception {
//        wandsworth.addCell(solitary);
//        solitary.addPrisoner(violentPrisoner1);
//
//        violentPrisoner1.hasVisitor(visitor);
//        assertEquals(0, violentPrisoner1.numberOfVisitors());
//
//    }
}
