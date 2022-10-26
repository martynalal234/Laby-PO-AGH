package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        switch (this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case WEST:
                return "Wschód";
            case EAST:
                return "Wschód";
            default:
                return "Error";
        }
    }

    public String next() {
        switch (this) {
            case EAST:
                return "SOUTH";
            case WEST:
                return "NORTH";
            case NORTH:
                return "EAST";
            case SOUTH:
                return "WEST";
            default:
                return "Error";

        }
    }

    public String previous() {
        switch (this) {
            case EAST:
                return "NORTH";
            case WEST:
                return "SOUTH";
            case NORTH:
                return "WEST";
            case SOUTH:
                return "EAST";
            default:
                return "Error";
        }

    }

    public Vector2d toUnitVector(){
        int x,y;

        switch(this) {
            case EAST:
                x = 1; y = 0;
                break;
            case WEST:
                x = -1; y = 0;
                break;
            case NORTH:
                x = 0; y = 1;
                break;
            case SOUTH:
                x = 0; y = -1;
                break;
            default:
                x = 0; y = 0;
        }
        return new Vector2d(x, y);
    }
}