package lol.kek;

public class Directions {
    public static char[] dirs = {'s', 'w', 'n', 'e'};

    public static int current = 0;

    public char getNext() {
        current++;
        current = current > 3 ? 0 : current;
        return dirs[current];
    }

    public char getPrev() {
        current--;
        current = current < 0 ? 3 : current;
        return dirs[current];
    }

    public char getCurrent(){
        return dirs[current];
    }
}
