package lol.kek;
// pasha_loh obelsya bloh u sobaki mexgdu  nog

import java.util.ArrayList;
import java.util.Arrays;

//WRWWLWWLWWLWLWRRWRWWWRWWRWLW - straight
//WWRRWLWLWWLWWLWWRWWRWWLW - reverse

public class Flank {

    Directions directions = new Directions();

    Board mainBoard;
    Cell focus;
    Cell prevFocus;

    String straight;
    String reverse;

    int x;
    int y;


    public Flank(String straight, String reverse) {
        int numW = 0;
        this.straight = straight.substring(1, straight.length() - 1);
        this.reverse = reverse.substring(1, reverse.length() - 1);


        for (char i :
                straight.toCharArray()) {
            if (i == 'W')
                numW++;
        }
        x = 0;
        y = numW-1;
        mainBoard = new Board(numW - 2);
        mainBoard.getCells()[x][y].canNorth = true;
//        mainBoard.getCells()[numW + 1][0].x = 0;
//        mainBoard.getCells()[numW + 1][0].y = 0;
        focus = mainBoard.getCells()[x][y];
    }

    void process() {
        char prevDirection = 'S';

        char currDirection = flanker(straight, prevDirection);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        prevDirection = currDirection == 'N' ? 'S' : currDirection == 'S' ? 'N' : currDirection == 'W' ? 'E' : 'W';
        System.out.println("invert "+ prevDirection);
        while (directions.getCurrent()!=prevDirection)
            directions.getNext();
        flanker(reverse, prevDirection);
    }

    public char flanker(String sequence, char prevDirection) {
        System.out.println(sequence);
        char currDirection = '0';

        for (int i = 0; i < sequence.length(); i++) {
            mainBoard.encrypt();
            System.out.println("i = " + i);
            System.out.println(sequence.charAt(i));
            currDirection = processDirection(prevDirection, sequence.charAt(i));
            System.out.println("curr "+currDirection);
            System.out.println("x y "+x+" "+y);
            boolean flag = false;
            if(sequence.length()-i - 1>0)
                flag = sequence.charAt(i + 1) == 'W';
            else
                flag = true;

            if (flag) {
                prevFocus = focus;
                switch (currDirection) {
                    //  y   x
                    case 'N':
                        // 0 -1
                        if(sequence.length()-i-1>0) {
                            focus = mainBoard.getCells()[--x][y];
                            prevFocus.canNorth = true;
                            focus.canSouth = true;
                        }
                        break;
                    case 'E':
                        // +1 0
                        if(sequence.length()-i-1>0) {
                            focus = mainBoard.getCells()[x][++y];
                            prevFocus.canEast = true;
                            focus.canWest = true;
                        }
                        break;
                    case 'W':
                        // -1 0
                        if(sequence.length()-i-1>0) {
                            focus = mainBoard.getCells()[x][--y];
                            prevFocus.canWest = true;
                            focus.canEast = true;
                        }
                        break;
                    case 'S':
                        // 0 +1
                        if(sequence.length()-i-1>0) {
                            focus = mainBoard.getCells()[++x][y];
                            prevFocus.canSouth = true;
                            focus.canNorth = true;
                        }
                        break;
                }
                prevDirection = currDirection;

            }
        }

        return currDirection;
    }


    char processDirection(char prev, char next) {

        if (next == 'W')
            return directions.getCurrent();
        else if (next == 'L')
            return directions.getPrev();
        else
            return directions.getNext();
    }

    public Board getMainBoard() {
        return mainBoard;
    }
}
