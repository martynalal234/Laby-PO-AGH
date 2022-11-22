package agh.ics.oop;
import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap{
    protected ArrayList<IMapElement> elems = new ArrayList<>();

    public boolean isOccupied(Vector2d position){
        for(IMapElement e : elems){
            if(position.equals(e.getPosition()))
                return true;
        }
        return false;
    }
    public Object objectAt(Vector2d position){
        for(IMapElement e : elems){
            if(position.equals(e.getPosition()))
                return e;
        }
        return null;
    }

    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        int x = 0;
        int y = 0;

        int z = 0;
        int w = 0;

        for (IMapElement e : elems) {
            x = Math.max(x, e.getPosition().x);
            y = Math.max(y, e.getPosition().y);
            z = Math.min(z, e.getPosition().x);
            w = Math.min(w, e.getPosition().y);
        }

        Vector2d lov = new Vector2d(z,w);
        Vector2d upper = new Vector2d(x,y);
        return map.draw(lov, upper);

    }

}
