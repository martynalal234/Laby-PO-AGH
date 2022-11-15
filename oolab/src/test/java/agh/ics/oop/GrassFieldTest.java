package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveTo() {
        GrassField grassField = new GrassField(5);
        Animal kotek = new Animal(grassField, new Vector2d(1,1));
        grassField.place(kotek);
        Animal piesek = new Animal(grassField, new Vector2d(1,2));
        grassField.place(piesek);

        assertTrue(grassField.canMoveTo(new Vector2d(3,3)));
        assertTrue(grassField.canMoveTo(new Vector2d(5,3)));
        assertFalse(grassField.canMoveTo((new Vector2d(1,1))));
    }

    @Test
    void place() {
        GrassField grassField = new GrassField(5);
        Animal kotek = new Animal(grassField, new Vector2d(1,1));
        grassField.place(kotek);
        Animal piesek = new Animal(grassField, new Vector2d(1,2));
        grassField.place(piesek);

        assertTrue(grassField.place(new Animal(grassField,new Vector2d(2,2))));
        assertFalse(grassField.place(new Animal(grassField, new Vector2d(1,1))));
    }

    @Test
    void isOccupied() {
        GrassField grassField = new GrassField(5);
        Animal kotek = new Animal(grassField, new Vector2d(1,1));
        grassField.place(kotek);
        Animal piesek = new Animal(grassField, new Vector2d(1,2));
        grassField.place(piesek);

        assertTrue(grassField.isOccupied(new Vector2d(1,1)));
        assertFalse(grassField.isOccupied(new Vector2d(2,1)));

    }

    @Test
    void objectAt() {
        GrassField grassField = new GrassField(5);
        Animal kotek = new Animal(grassField, new Vector2d(1,1));
        grassField.place(kotek);
        Animal piesek = new Animal(grassField, new Vector2d(1,2));
        grassField.place(piesek);

        assertEquals(null, grassField.objectAt(new Vector2d(3,3)));
        assertEquals(kotek, grassField.objectAt(new Vector2d(1,1)));
    }
}