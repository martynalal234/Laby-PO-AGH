package agh.ics.oop;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap{
    protected HashMap<Vector2d, IMapElement> elems = new HashMap<>();

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

        for(Vector2d p : elems.keySet()){
            x = Math.max(x, p.x);
            y = Math.max(y, p.y);
            z = Math.min(z, p.x);
            w = Math.min(w, p.y);
        }

        Vector2d low = new Vector2d(z,w);
        Vector2d upper = new Vector2d(x,y);
        return map.draw(low, upper);

    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IMapElement e = elems.get(oldPosition);
        elems.remove(oldPosition);
        elems.put(newPosition, e);
    }

}
