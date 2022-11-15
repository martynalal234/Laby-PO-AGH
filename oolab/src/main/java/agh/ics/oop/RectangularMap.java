package agh.ics.oop;
import java.util.Random;
import java.util.Vector;

public class RectangularMap implements IWorldMap{
    private int height, width;
    private Animal[][] map;

    public RectangularMap(int height, int width){
        this.height = height;
        this.width = width;

        map = new Animal[width][height];
    }

    public boolean canMoveTo(Vector2d position){
        if(position.x < width && position.y < height && position.x >= 0 && position.y >=0
                && map[position.x][position.y] == null){
            return true;
        }
        return false;
    }

    public boolean place(Animal animal){
        if (!isOccupied(animal.getPosition())){
            map[animal.getPosition().x][animal.getPosition().y] = animal;
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position){
        if(map[position.x][position.y] == null){
            return false;
        }
        return true;
    }
    public Object objectAt(Vector2d position){
        return map[position.x][position.y];
    }

    public String toString(){
        for(int i = 0 ; i < width; i++){
            for(int j = 0; j <height; j++){
                if (isOccupied(new Vector2d(i,j))){
                    Animal temp = (Animal)objectAt(new Vector2d(i,j));
                    if (!temp.isAt(new Vector2d(i,j))){
                        map[i][j] = null;
                        map[temp.getPosition().x][temp.getPosition().y] = temp;
                    }
                }
            }
        }
        MapVisualizer kotek = new MapVisualizer(this);
        Vector2d leftLover = new Vector2d(0,0);
        Vector2d rightUpper = new Vector2d(width-1,height-1);
        return kotek.draw(leftLover,rightUpper);
    }

}

