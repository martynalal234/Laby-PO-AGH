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
            elems.add(g);
    }
    public boolean canMoveTo(Vector2d position){
        for (IMapElement e : elems){
            if (e instanceof Animal && position.equals(e.getPosition()))
                return false;
        }
        return true;
    }

    public boolean place(Animal animal){
        for(IMapElement e : elems){
            if(animal.getPosition().equals(e.getPosition()) &&
                e instanceof Animal)
                return false;
        }
        elems.add(animal);
        return true;
    }

    @Override
    public String toString() {
        int cnt = 0;
        for(int i = 0; i < elems.size(); i++){
            for(int j = i + 1; j < elems.size(); j++){
                if(elems.get(i).getPosition().equals(elems.get(j).getPosition())){
                    if(elems.get(i) instanceof Grass) {
                        elems.remove(i);
                    } else if(elems.get(j) instanceof Grass){
                        elems.remove(j);
                    }
                    cnt++;
                }
            }
        }

        ArrayList<Grass> grasses = new ArrayList<>();
        for(int i = 0; i < cnt; i++){
            while (true) {
                int x, y;
                Random random = new Random();
                x = random.nextInt((int)Math.sqrt(nmax*10) + 1);
                y = random.nextInt((int)Math.sqrt(nmax*10) + 1);

                Vector2d pos = new Vector2d(x,y);
                Grass g = new Grass(pos);

                boolean bool = true;
                for( int j = 0; j < i; j++){
                    if (grasses.get(j) == g) {
                        bool = false;
                    }
                }
                for(IMapElement e : elems){
                    if(g.equals(e.getPosition()))
                        bool = false;
                }
                if(bool){
                    grasses.add(g);
                    break;
                }
            }
        }
        for(Grass g : grasses)
            elems.add(g);

        return super.toString();
    }
}