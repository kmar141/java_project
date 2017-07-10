package com.example.kieran.prison;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Kieran on 10/07/2017.
 */

public class PrisonTest {

    Prisoner prisoner;
    Cell cell;

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
}
