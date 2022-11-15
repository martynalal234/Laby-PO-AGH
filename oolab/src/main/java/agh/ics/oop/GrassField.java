package agh.ics.oop;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class GrassField implements IWorldMap{
    Grass[] grasses;
    ArrayList<Animal> animalList;

    public GrassField(int n){
        grasses = new Grass[n];
        animalList = new ArrayList<>();

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
                    if (grasses[j] == g) {
                        bool = false;
                    }
                }
                if(bool){
                    grasses[i] = g;
                    break;
                }
            }

        }
    }
    public boolean canMoveTo(Vector2d position){
        for (Animal a : animalList){
            if (a.getPosition().equals(position))
                return false;
        }
        return true;
    }

    public boolean place(Animal animal){
        if (isOccupied(animal.getPosition()))
            return false;

        animalList.add(animal);
        return true;
    }
    public boolean isOccupied(Vector2d position){
        for(int i = 0; i < grasses.length; i++){
            if (grasses[i].getPosition().equals(position))
                return true;
        }

        for (Animal a : animalList){
            if (a.getPosition().equals(position))
                return true;
        }
        return false;
    }
    public Object objectAt(Vector2d position) {
        for (Animal a : animalList) {
            if (a.getPosition().equals(position))
                return a;
        }

        for (int i = 0; i < grasses.length; i++) {
            if (grasses[i].getPosition().equals(position))
                return grasses[i];
        }

        return null;
    }

    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        int x = 0;
        int y = 0;

        int z = 0;
        int w = 0;

        for (Animal a : animalList) {
            x = Math.max(x, a.getPosition().x);
            y = Math.max(y, a.getPosition().y);
            z = Math.min(z, a.getPosition().x);
            w = Math.min(w, a.getPosition().y);

        }

        for (int i = 0; i < grasses.length; i++) {
            x = Math.max(x, grasses[i].getPosition().x);
            y = Math.max(y, grasses[i].getPosition().y);
            z = Math.min(z, grasses[i].getPosition().x);
            w = Math.min(w,grasses[i].getPosition().y);
        }

        Vector2d lov = new Vector2d(z,w);
        Vector2d upper = new Vector2d(x,y);
        return map.draw(lov, upper);

    }

}
