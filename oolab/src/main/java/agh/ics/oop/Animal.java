package agh.ics.oop;

import java.util.Vector;
import java.util.ArrayList;
public class Animal implements IMapElement {
    private MapDirection orient = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private final ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
    private final ArrayList<IWorldMap> maps = new ArrayList<>();;

    public Animal(Vector2d initialPosition){
        position = initialPosition;
    }


    @Override
    public String toString(){ return this.orient.toString(); }

    private void positionChanged(Vector2d old, Vector2d new_pos){
        for(IPositionChangeObserver m : observers){
            m.positionChanged(old, new_pos);
        }
    }
    public void move(MoveDirection direction) {
        Vector2d new_position = new Vector2d(this.position.x,this.position.y);

        switch (direction) {
            case LEFT -> this.orient = this.orient.previous();
            case RIGHT -> this.orient = this.orient.next();
            case FORWARD -> new_position = this.position.add(this.orient.toUnitVector());
            case BACKWARD -> new_position = this.position.subtract(this.orient.toUnitVector());
        }
        for(IWorldMap m : maps){
            if(!m.canMoveTo(new_position))
                return;
        }
        positionChanged(this.position, new_position);
        position = new_position;
    }
    public Vector2d getPosition(){
        return this.position;
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
    public void addMap(IWorldMap m) { maps.add(m); }
}