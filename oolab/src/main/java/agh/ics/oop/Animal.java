package agh.ics.oop;

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

        Vector2d position_prev = this.position;
        switch (direction) {
            case LEFT -> this.orient = this.orient.previous();
            case RIGHT -> this.orient = this.orient.next();
            case FORWARD -> this.position = this.position.add(this.orient.toUnitVector());
            case BACKWARD -> this.position = this.position.subtract(this.orient.toUnitVector());
        }
        if (!map.canMoveTo(position)){
            position = position_prev;
        }

    }
    public Vector2d getPosition(){
        return this.position;
    }
}