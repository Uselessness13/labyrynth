package lol.kek;

import java.util.ArrayList;
import java.util.Arrays;

public class Flank {

    ArrayList<Movement> straightMovements;
    ArrayList<Movement> reverseMovements;
    int straightWidth;
    int straightLength;
    int reverseWidth;
    int reverseLength;

    public Flank() {
        straightMovements = new ArrayList<>();
        reverseMovements = new ArrayList<>();

    }

    void process(String straight, String reverse) {
        char buffDirection = 's';
        for (int i = 0; i < straight.length(); i++) {
            straightMovements.add(new Movement(processDirection(buffDirection, straight.charAt(i)), straight.charAt(i) == 'W'));
        }

    }



    char processDirection(char prev, char next) {
        Directions directions = new Directions();
        if (prev == next && next == 'W')
            return directions.getCurrent();
        else if (next == 'R')
            return directions.getNext();
        else
            return directions.getPrev();
    }

}
