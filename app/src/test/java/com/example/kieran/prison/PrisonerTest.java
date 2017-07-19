package com.example.kieran.prison;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Kieran on 10/07/2017.
 */

public class PrisonerTest {

    Prisoner prisoner;
    Prisoner prisoner2;
    Prisoner prisoner3;
    Prisoner violentPrisoner1;
    Prisoner violentPrisoner2;
    Food food;
    Prison wandsworth;
    Prison brixton;
    Cell cell1A;
    Cell cell1B;
    Visitor visitor;
    Cell solitary;


    @Before
    public void before(){
        prisoner = new Prisoner("Rick");
        prisoner2 = new Prisoner("Morty");
        prisoner3 = new Prisoner("Jerry");
        violentPrisoner1 = new Prisoner("Bebop", true);
        violentPrisoner2 = new Prisoner("Rocksteady", true);
        cell1A = new Cell(false);
        cell1B = new Cell(true);
        wandsworth = new Prison();
        brixton = new Prison();
        visitor = new Visitor();
        solitary = new Cell(true);



    }

    @Test
    public void testPrisonerName() throws Exception {
        assertEquals("Rick", prisoner.getName());

    }

    @Test
    public void testPrisonerCanEat() throws Exception {
        prisoner.feedPrisoner(food);
        assertEquals(1, prisoner.foodCount());

    }


    @Test
    public void bellyEmpty(){
        assertEquals(0, prisoner.foodCount());
    }

    @Test
    public void cannotEatWhenBellyFull(){
        for (int i = 0; i < 7; i++){
            prisoner.feedPrisoner(food);
        }
        assertEquals(5, prisoner.foodCount());
    }


    @Test
    public void testPrisonerViolent() throws Exception {
        assertEquals(true, violentPrisoner1.isViolent());
        assertEquals(false, prisoner2.isViolent());
    }

    @Test
    public void testCanMovePrison() throws Exception {
        wandsworth.addCell(cell1A);
        cell1A.addPrisoner(violentPrisoner1);
        brixton.addCell(cell1B);
        cell1A.emptyCell();
        cell1B.addPrisoner(violentPrisoner1);
        assertEquals(1, cell1B.cellCount());
    }

    @Test
    public void testPrisonerRiot() throws Exception {
        wandsworth.addCell(cell1A);
        cell1A.addPrisoner(prisoner);
        prisoner.feedPrisoner(food);

        Prisoner spyPrisoner = Mockito.spy(prisoner);
        Mockito.when(spyPrisoner.prisonerRiotCheck()).thenReturn(1);
        cell1A.prisonerRiot(spyPrisoner);
        assertNull(cell1A.cellCount());

    }
}
