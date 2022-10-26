package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        assertEquals("(1, 2)", new Vector2d(1,2).toString());
        assertEquals("(0, 0)", new Vector2d(0,0).toString());
        assertEquals("(1, -8)", new Vector2d(1,-8).toString());
    }

    @Test
    void precedes() {
        assertTrue(new Vector2d(1,3).precedes(new Vector2d(2,4)));
        assertTrue(new Vector2d(-10,-30).precedes(new Vector2d(2,4)));
        assertFalse(new Vector2d(-10,-30).precedes(new Vector2d(-20,4)));
    }

    @Test
    void follows() {
        assertTrue(new Vector2d(1,3).precedes(new Vector2d(2,4)));
        assertFalse(new Vector2d(5,8).precedes(new Vector2d(10,3)));
        assertTrue(new Vector2d(3,3).precedes(new Vector2d(3,4)));
        assertFalse(new Vector2d(-1,3).precedes(new Vector2d(-100,4)));
        assertFalse(new Vector2d(1,3).precedes(new Vector2d(-5,4)));
    }

    @Test
    void add() {
        assertEquals(new Vector2d(2,3), new Vector2d(1,2).add(new Vector2d(1,1)));
        assertEquals(new Vector2d(-10,30), new Vector2d(-11,2).add(new Vector2d(1,28)));
    }

    @Test
    void subtract() {
        assertEquals(new Vector2d(0,1), new Vector2d(1,2).subtract(new Vector2d(1,1)));
        assertEquals(new Vector2d(-12,-26), new Vector2d(-11,2).subtract(new Vector2d(1,28)));
    }

    @Test
    void upperRight() {
        assertEquals(new Vector2d(1,2), new Vector2d(1,2).upperRight(new Vector2d(1,1)));
        assertEquals(new Vector2d(10,2), new Vector2d(5,2).upperRight(new Vector2d(10,-1)));
    }

    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(1,1), new Vector2d(1,5).lowerLeft(new Vector2d(1,1)));
        assertEquals(new Vector2d(5,-1), new Vector2d(5,2).lowerLeft(new Vector2d(10,-1)));
    }

    @Test
    void opposite() {
        assertEquals(new Vector2d(1,3), (new Vector2d(-1,-3)).opposite());
    }

    @Test
    void testEquals() {
        assertTrue(new Vector2d(1,3).equals(new Vector2d(1,3)));
        assertFalse(new Vector2d(1,3).equals(new Vector2d(1,34)));
    }
}