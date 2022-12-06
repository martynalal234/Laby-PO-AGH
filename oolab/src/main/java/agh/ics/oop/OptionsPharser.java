package agh.ics.oop;

import java.util.Vector;

public class OptionsPharser {

    public MoveDirection[] parse(String[] args) {
        Vector<MoveDirection> tmp = new Vector<MoveDirection>();
        for(String arg: args){
            switch (arg) {
                case "f" -> tmp.add(MoveDirection.FORWARD);
                case "b" -> tmp.add(MoveDirection.BACKWARD);
                case "l" -> tmp.add(MoveDirection.LEFT);
                case "r" -> tmp.add(MoveDirection.RIGHT);
                default -> {throw new IllegalArgumentException(arg + " is not legal move specification");}
            }
        }

        MoveDirection[] enum_tab = new MoveDirection[tmp.size()];
        for(int i = 0; i < tmp.size(); i++){
            enum_tab[i] = tmp.get(i);
        }
        return enum_tab;
    }
}
