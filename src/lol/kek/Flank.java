package lol.kek;

import java.util.ArrayList;
import java.util.Arrays;

//WRWWLWWLWWLWLWRRWRWWWRWWRWLW - straight
//WWRRWLWLWWLWWLWWRWWRWWLW - reverse

public class Flank {

    Board mainBoard;
    Cell focus;
    Cell prevFocus;

    String straight;
    String reverse;

    int x;
    int y;


    public Flank(String straight, String reverse) {
        int numW = 0;
        this.straight = straight.substring(0, straight.length() - 1);
        this.reverse = reverse.substring(1, reverse.length() - 1);


        for (char i :
                straight.toCharArray()) {
            if (i == 'W')
                numW++;
        }
        x = numW - 1;
        y = 0;
        mainBoard = new Board(numW - 2);
        mainBoard.getCells()[numW + 1][0].canNorth = true;
//        mainBoard.getCells()[numW + 1][0].x = 0;
//        mainBoard.getCells()[numW + 1][0].y = 0;
        focus = mainBoard.getCells()[numW + 1][0];
    }

    void process() {
        char prevDirection = 'S';
        char currDirection;

        for (int i = 0; i < straight.length(); i++) {
            System.out.println("i = "+i);
            currDirection = processDirection(prevDirection, straight.charAt(i));
            if (straight.charAt(i + 1) == 'W') {
                prevFocus = focus;
                switch (currDirection) {
                    //  y   x
                    case 'N':
                        // 0 -1
                        focus = mainBoard.getCells()[y][x-1];
                        x--;
                        prevFocus.canSouth = true;
                        focus.canNorth = true;
                        break;
                    case 'E':
                        // +1 0
                        focus = mainBoard.getCells()[y+1][x];
                        y++;
                        prevFocus.canWest = true;
                        focus.canEast = true;
                        break;
                    case 'W':
                        // -1 0
                        focus = mainBoard.getCells()[y-1][x];
                        y--;
                        prevFocus.canEast = true;
                        focus.canWest = true;
                        break;
                    case 'S':
                        // 0 +1
                        focus = mainBoard.getCells()[y][x+1];
                        x--;
                        prevFocus.canNorth = true;
                        focus.canSouth = true;

                        break;
                }

            }
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
