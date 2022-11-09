package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveTo() {
        RectangularMap map = new RectangularMap(4,4);
        Animal kotek = new Animal(map, new Vector2d(1,1));
        map.place(kotek);
        Animal piesek = new Animal(map, new Vector2d(1,2));
        map.place(piesek);

        assertTrue(map.canMoveTo(new Vector2d(3,3)));
        assertFalse(map.canMoveTo(new Vector2d(5,3)));
        assertFalse(map.canMoveTo(new Vector2d(0,-1)));

    }

    @Test
    void place() {
        RectangularMap map = new RectangularMap(4,4);
        Animal kotek = new Animal(map, new Vector2d(1,1));
        map.place(kotek);
        Animal piesek = new Animal(map, new Vector2d(1,2));
        map.place(piesek);

        assertTrue(map.place(new Animal(map,new Vector2d(2,2))));
        assertFalse(map.place(new Animal(map, new Vector2d(1,1))));

    }

    @Test
    void isOccupied() {
        RectangularMap map = new RectangularMap(4,4);
        Animal kotek = new Animal(map, new Vector2d(1,1));
        map.place(kotek);
        Animal piesek = new Animal(map, new Vector2d(1,2));
        map.place(piesek);

        assertTrue(map.isOccupied(new Vector2d(1,1)));
        assertFalse(map.isOccupied(new Vector2d(2,1)));


    }

    @Test
    void objectAt() {
        RectangularMap map = new RectangularMap(4,4);
        Animal kotek = new Animal(map, new Vector2d(1,1));
        map.place(kotek);
        Animal piesek = new Animal(map, new Vector2d(1,2));
        map.place(piesek);

        assertEquals(null, map.objectAt(new Vector2d(3,3)));
        assertEquals(kotek, map.objectAt(new Vector2d(1,1)));
    }
}