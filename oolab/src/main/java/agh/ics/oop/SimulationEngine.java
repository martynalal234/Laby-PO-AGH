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
            animals[i] = new Animal(positions[i]);
            animals[i].addObserver((IPositionChangeObserver) map);
            animals[i].addMap(map);
            if(!map.place(animals[i]))
                throw new IllegalArgumentException("Animal can't be placed on " + positions[i].toString());
        }
    }

    public void run(){
        for(int i = 0; i < moves.length; i++){
            animals[i % animals.length].move(moves[i]);
            System.out.print(map);
        }
    }
}
