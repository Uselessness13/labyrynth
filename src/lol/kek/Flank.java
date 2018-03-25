package lol.kek;

import java.util.ArrayList;
import java.util.Arrays;

//WRWWLWWLWWLWLWRRWRWWWRWWRWLW - straight
//WWRRWLWLWWLWWLWWRWWRWWLW - reverse

public class Flank {

    Board mainBoard;
    Cell focus;

    String straight;
    String reverse;


    public Flank(String straight, String reverse) {
        int numW = 0;
        this.straight = straight.substring(1, straight.length() - 1);
        this.reverse = reverse.substring(1, reverse.length() - 1);


        for (char i :
                straight.toCharArray()) {
            if (i == 'W')
                numW++;
        }

        mainBoard = new Board(numW - 2);
        mainBoard.getCells()[numW + 1][0].canNorth = true;
//        mainBoard.getCells()[numW + 1][0].x = 0;
//        mainBoard.getCells()[numW + 1][0].y = 0;
        focus = mainBoard.getCells()[numW+1][0];
    }

    void process() {
        char prevDirection = 'S';
        char currDirection;

        for (int i = 0; i < straight.length(); i++) {
            currDirection = processDirection(prevDirection,straight.charAt(i));


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
