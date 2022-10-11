package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("Start");
        String[] tab = {"f","f","r","l"};
        run(com(tab));
        System.out.println("Stop");

    }
    public static Direction[] com(String[] tab){
        Direction[] enum_tab = new Direction[tab.length];
        for(int i = 0; i < tab.length; i++){
            switch (tab[i]) {
                case "f" -> enum_tab[i] = Direction.FORWARD;
                case "b" -> enum_tab[i] = Direction.BACKWARD;
                case "l" -> enum_tab[i] = Direction.RIGHT;
                case "r" -> enum_tab[i] = Direction.LEFT;
            }
        }
        return enum_tab;
    }
    public static void run(Direction[] array){
   //     System.out.println("Start");
        for( int i=0; i < array.length ; i++) {
            switch (array[i]) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak idzie w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak idzie w lewo");
                    break;
            }
        }


    }

}
