package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void toUnitVector() {
        assertEquals(new Vector2d(1,0), MapDirection.EAST.toUnitVector());
        assertEquals(new Vector2d(-1,0), MapDirection.WEST.toUnitVector());
        assertEquals(new Vector2d(0,1), MapDirection.NORTH.toUnitVector());
        assertEquals(new Vector2d(0,-1), MapDirection.SOUTH.toUnitVector());

    }

    @Test
    void next(){
        assertEquals("S", MapDirection.EAST.next());
        assertEquals("N", MapDirection.WEST.next());
        assertEquals("E", MapDirection.NORTH.next());
        assertEquals("W", MapDirection.SOUTH.next());
    }

    @Test
    void previous(){
        assertEquals("N", MapDirection.EAST.previous());
        assertEquals("S", MapDirection.WEST.previous());
        assertEquals("W", MapDirection.NORTH.previous());
        assertEquals("E", MapDirection.SOUTH.previous());

    }
}