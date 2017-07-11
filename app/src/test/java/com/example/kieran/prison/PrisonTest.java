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
    Cell cell;
    Food food;

    @Before
    public void before(){
        prisoner = new Prisoner("Rick");
        cell = new Cell(1);
    }

    @Test
    public void testPrisonerName() throws Exception {
        assertEquals("Rick", prisoner.getName());

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
    public void testPrisonerNameByCell() throws Exception {
        assertEquals("Rick", cell.getPrisonerName());

    }
}
