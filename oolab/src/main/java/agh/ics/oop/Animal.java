package agh.ics.oop;

import java.util.Vector;

public class Animal {
    private MapDirection orient = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        position = initialPosition;
    }


    @Override
    public String toString(){ return this.orient.toString(); }

    public boolean isAt(Vector2d other){
        if (position.equals(other)){return true;}
        return false;
    }

    public void move(MoveDirection direction) {
        Vector2d new_position = new Vector2d(this.position.x,this.position.y);

        switch (direction) {
            case LEFT -> this.orient = this.orient.previous();
            case RIGHT -> this.orient = this.orient.next();
            case FORWARD -> new_position = this.position.add(this.orient.toUnitVector());
            case BACKWARD -> new_position = this.position.subtract(this.orient.toUnitVector());
        }
        if (map.canMoveTo(new_position)){
            position = new_position;
        }

    }
    public Vector2d getPosition(){
        return this.position;
    }
}