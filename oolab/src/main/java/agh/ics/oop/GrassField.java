package agh.ics.oop;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap implements IWorldMap{
    private final int nmax;
    public GrassField(int n){
        nmax = n;
        ArrayList<Grass> grasses = new ArrayList<Grass>();
        for(int i = 0; i < n; i++){
            while (true) {
                int x, y;
                Random random = new Random();
                x = random.nextInt((int)Math.sqrt(n*10) + 1);
                y = random.nextInt((int)Math.sqrt(n*10) + 1);

                Vector2d pos = new Vector2d(x,y);
                Grass g = new Grass(pos);

                boolean bool = true;
                for( int j = 0; j < i; j++){
                    if (grasses.get(j) == g) {
                        bool = false;
                    }
                }
                if(bool){
                    grasses.add(g);
                    break;
                }
            }
        }
        for(Grass g : grasses)
            elems.put(g.getPosition(), g);
    }
    public boolean canMoveTo(Vector2d position){
        if(elems.containsKey(position) && elems.get(position) instanceof Animal)
            return false;

        return true;
    }

    public boolean place(Animal animal){
        if(canMoveTo(animal.getPosition()))
            elems.put(animal.getPosition(), animal);
        else
            return false;
        boundary.addVector(animal.getPosition());
        return true;
    }
}