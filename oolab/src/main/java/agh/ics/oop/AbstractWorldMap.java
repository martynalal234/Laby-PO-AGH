package agh.ics.oop;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected final HashMap<Vector2d, IMapElement> elems = new HashMap<>();

    protected final MapBoundary boundary = new MapBoundary();

    public boolean isOccupied(Vector2d position){
        return elems.containsKey(position);
    }
    public Object objectAt(Vector2d position){
        return elems.get(position);
    }

    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        int x = 0;
        int y = 0;

        int z = 0;
        int w = 0;

        Vector2d low = boundary.lowerBound();
        Vector2d upper = boundary.upperBound();
        return map.draw(low, upper);

    }
    public Vector2d getLowerLeft(){
        return boundary.lowerBound();
    }

    public Vector2d getUpperRight(){
        return boundary.upperBound();
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IMapElement e = elems.get(oldPosition);
        elems.remove(oldPosition);
        elems.put(newPosition, e);
        boundary.positionChanged(oldPosition, newPosition);
    }
}
