package agh.ics.oop;

import java.util.Map;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        switch (this) {
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
            case EAST:
                return "E";
            default:
                return "Error";
        }
    }

    // W prawo
    public MapDirection next() {
        switch (this) {
            case EAST:
                return MapDirection.SOUTH;
            case WEST:
                return MapDirection.NORTH;
            case NORTH:
                return MapDirection.EAST;
            case SOUTH:
                return MapDirection.WEST;
            default:
                return MapDirection.NORTH;
        }
    }

    // w lewo
    public MapDirection previous() {
        switch (this) {
            case EAST:
                return MapDirection.NORTH;
            case WEST:
                return MapDirection.SOUTH;
            case NORTH:
                return MapDirection.WEST;
            case SOUTH:
                return MapDirection.EAST;
            default:
                return MapDirection.NORTH;
        }

    }

    public Vector2d toUnitVector(){

        switch(this) {
            case EAST:
                return new Vector2d(1, 0);
            case WEST:
                return new Vector2d(-1, 0);
            case NORTH:
                return new Vector2d(0, 1);
            case SOUTH:
                return new Vector2d(0, -1);
            default:
                return new Vector2d(0, 0);
        }
    }
}