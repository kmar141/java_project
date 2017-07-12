package com.example.kieran.prison;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.junit.Before;
import org.junit.Test;

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


    @Before
    public void before(){
        prisoner = new Prisoner("Rick");
        prisoner2 = new Prisoner("Morty");
        prisoner3 = new Prisoner("Jerry");
        violentPrisoner1 = new Prisoner("Bebop", true);
        violentPrisoner2 = new Prisoner("Rocksteady", true);


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
    public void testPrisonerRemove() throws Exception {
        prisoner.deleteByName("Rick");
        assertEquals("Rick", prisoner.getName());

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


}
