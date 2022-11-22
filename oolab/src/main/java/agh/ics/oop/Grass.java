package agh.ics.oop;

public class Grass implements IMapElement{

    private Vector2d grassPosition;

    public Grass(Vector2d position){
        grassPosition = position;
    }

    public Vector2d getPosition(){
        return grassPosition;
    }

    public String toString(){
        return "*";
    }
}
