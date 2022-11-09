package agh.ics.oop;

public class SimulationEngine implements IEngine{
    private IWorldMap map;
    private Animal[] animals;
    private MoveDirection[] moves;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.map = map;
        this.moves = moves;
        animals = new Animal[positions.length];
        for(int i = 0; i < positions.length; i++){
            animals[i] = new Animal(map, positions[i]);
            map.place(animals[i]);
        }
    }

    public void run(){
        for(int i = 0; i < moves.length; i++){
            animals[i % animals.length].move(moves[i]);
            System.out.print(map);
        }
    }



}
