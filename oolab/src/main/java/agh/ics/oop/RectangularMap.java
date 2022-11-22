package agh.ics.oop;
import java.util.Random;
import java.util.Vector;

public class RectangularMap extends AbstractWorldMap implements IWorldMap{
    int width, height;
    public RectangularMap(int height, int width){
        this.height = height;
        this.width = width;
    }

    public boolean canMoveTo(Vector2d position){
        if(position.x < 0 || position.x > width ||
                position.y < 0 || position.y > height)
            return false;

        if(elems.containsKey(position))
            return false;
        return true;
    }

    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition()))
            return false;
        elems.put(animal.getPosition(), animal);
        return true;
    }
}