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
        assertEquals("SOUTH", MapDirection.EAST.next());
        assertEquals("NORTH", MapDirection.WEST.next());
        assertEquals("EAST", MapDirection.NORTH.next());
        assertEquals("WEST", MapDirection.SOUTH.next());
    }

    @Test
    void previous(){
        assertEquals("NORTH", MapDirection.EAST.previous());
        assertEquals("SOUTH", MapDirection.WEST.previous());
        assertEquals("WEST", MapDirection.NORTH.previous());
        assertEquals("EAST", MapDirection.SOUTH.previous());

    }
}