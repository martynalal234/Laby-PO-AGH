package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.SortedSet;

public class MapBoundary implements IPositionChangeObserver{
    private static class VectorComparatorX implements Comparator<Vector2d> {
        public int compare(Vector2d a, Vector2d b){
            if(a.x < b.x)
                return -1;
            if(a.x == b.x){
                if(a.y < b.y)
                    return -1;
                return 1;
            }
            return 1;
        }
    }
    private static class VectorComparatorY implements Comparator<Vector2d> {
        public int compare(Vector2d a, Vector2d b){
            if(a.y < b.y)
                return -1;
            if(a.y == b.y){
                if(a.x < b.x)
                    return -1;
                return 1;
            }
            return 1;
        }
    }
    private final TreeSet<Vector2d> positions_x = new TreeSet<>(new VectorComparatorX());
    private final TreeSet<Vector2d> positions_y = new TreeSet<>(new VectorComparatorY());

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        positions_x.remove(oldPosition);
        positions_y.remove(oldPosition);
        positions_x.add(newPosition);
        positions_y.add(newPosition);
    }

    public void addVector(Vector2d v){
        positions_x.add(v);
        positions_y.add(v);
    }

    public Vector2d upperBound(){
        Vector2d xs = positions_x.last();
        Vector2d ys = positions_y.last();

        return new Vector2d(xs.x, ys.y);
    }

    public Vector2d lowerBound(){
        Vector2d xs = positions_x.first();
        Vector2d ys = positions_y.first();

        return new Vector2d(xs.x, ys.y);
    }

}