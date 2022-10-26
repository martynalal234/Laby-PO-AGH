package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

//    Napisz testy integracyjne weryfiujące poprawność implementacji. Uwzględnij:
//
//    czy zwierzę ma właściwą orientację,
//    czy zwierzę przemieszcza się na właściwe pozycje,
//    czy zwierzę nie wychodzi poza mapę,
//    czy dane wejściowe podane jako tablica łańcuchów znaków są poprawnie interpretowane

    @Test
    void animalMove() {

        Animal Kotek = new Animal();
        assertEquals(true, Kotek.isAt(new Vector2d(2, 2)));
        assertEquals("((2, 2), Północ)", Kotek.toString());
        MoveDirection[] new_position = new OptionsPharser().pharse(new String[]{"f", "p","f", "f","f", "b", "l", "o","f","1"});
        World.AnimalMove(new_position, Kotek);
        assertEquals("((1, 3), Zachód)", Kotek.toString());
        assertEquals(true, Kotek.isAt(new Vector2d(1, 3)));
        MoveDirection[] next_position = new OptionsPharser().pharse(new String[]{"l", "b", "b", "b", "b", "l", "r"});
        World.AnimalMove(next_position, Kotek);
        assertEquals("((1, 4), Południe)", Kotek.toString());
        assertEquals(true, Kotek.isAt(new Vector2d(1, 4)));
        MoveDirection[] other_position = new OptionsPharser().pharse(new String[]{"pl", "-1", "ll", "3", "f", "f", "f"});
        World.AnimalMove(other_position, Kotek);
        assertEquals("((1, 1), Południe)", Kotek.toString());
        assertEquals(true, Kotek.isAt(new Vector2d(1, 1)));





    }
}