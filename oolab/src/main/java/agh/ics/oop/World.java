package agh.ics.oop;

public class World {
    public static void main(String[] args){

        Animal Kotek = new Animal();
        MoveDirection[] new_position = new OptionsPharser().pharse(new String[]{"f", "f", "f", "f", "f", "f"});
        AnimalMove(new_position, Kotek);
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
