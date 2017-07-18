package com.example.kieran.prison;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Kieran on 18/07/2017.
 */

public class PrisonTest {
    Cell cell1A;
    Cell cell1B;
    Cell solitary;
    Prison wandsworth;

    @Before
    public void before() {
        cell1A = new Cell();
        cell1B = new Cell();
        solitary = new Cell();
        wandsworth = new Prison();
    }

    @Test
    public void testCanAddCell() throws Exception {
        wandsworth.addCell(cell1A);
        assertEquals(1, wandsworth.totalCells());
    }

    @Test
    public void testCanRemoveCell() throws Exception {
        wandsworth.addCell(cell1A);
        wandsworth.removeCell(cell1A);
        assertEquals(0, wandsworth.totalCells());
    }


}
