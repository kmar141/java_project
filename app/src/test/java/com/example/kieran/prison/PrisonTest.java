package com.example.kieran.prison;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Kieran on 10/07/2017.
 */

public class PrisonTest {

    Prisoner prisoner;
    Prisoner prisoner2;
    Prisoner prisoner3;
    Cell cell;
    Food food;


    @Before
    public void before(){
        prisoner = new Prisoner("Rick");
        prisoner2 = new Prisoner("Morty");
        prisoner3 = new Prisoner("Jerry");
        cell = new Cell();


    }

    @Test
    public void testCell() throws Exception {
        assertNotNull(cell);
    }

    @Test
    public void testPrisonerCanEat() throws Exception {
        prisoner.feedPrisoner(food);
        assertEquals(1, prisoner.foodCount());

    }

    @Test
    public void testPrisonerRemove() throws Exception {
        prisoner.deleteByName("Rick");
        assertEquals("Rick", prisoner.getName());

    }

    @Test
    public void cannotEatWhenBellyFull(){
        for (int i = 0; i < 7; i++){
            prisoner.feedPrisoner(food);
        }
        assertEquals(5, prisoner.foodCount());
    }

    @Test
    public void testCanAddPrisoner() throws Exception {
        cell.addPrisoner(prisoner);
        assertEquals(1, cell.cellCount());
    }

    @Test
    public void testCellClear() throws Exception {
        cell.addPrisoner(prisoner);
        cell.emptyCell();
        assertEquals(0, cell.cellCount());

    }

    @Test
    public void testPrisonerName() throws Exception {
        cell.addPrisoner(prisoner);
        assertEquals("Rick", cell.getPrisonerName());

    }

    @Test
    public void testAddThreePrisoners() throws Exception {
        cell.addPrisoner(prisoner);
        cell.addPrisoner(prisoner2);
        cell.addPrisoner(prisoner3);
        assertEquals(3, cell.cellCount());

    }

    @Test
    public void testGetPrionerNames() throws Exception {
        cell.addPrisoner(prisoner);
        cell.addPrisoner(prisoner2);
        cell.addPrisoner(prisoner3);
        assertEquals("Rick, Morty, Jerry", cell.getPrisonerNames());

    }
}
