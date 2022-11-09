package agh.ics.oop;

public class World {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionsPharser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }

    public static void AnimalMove(MoveDirection[] args, Animal kot){
        for( int i=0; i < args.length ; i++) {
            switch (args[i]) {
                case FORWARD:
                    kot.move(MoveDirection.FORWARD);
                    break;
                case BACKWARD:
                    kot.move(MoveDirection.BACKWARD);
                    break;
                case RIGHT:
                    kot.move(MoveDirection.RIGHT);
                    break;
                case LEFT:
                    kot.move(MoveDirection.LEFT);
                    break;
            }
        }

    }
}
