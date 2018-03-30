package lol.kek;

public class Cell {

    public boolean canNorth;
    public boolean canSouth;
    public boolean canWest;
    public boolean canEast;

//    int x;
//    int y;

    public Cell(boolean canNorth, boolean canSouth, boolean canWest, boolean canEast) {
        this.canNorth = canNorth;
        this.canSouth = canSouth;
        this.canWest = canWest;
        this.canEast = canEast;
    }

    public char encrypt() {
        int b = (canEast ? 8 : 0) + (canWest ? 4 : 0) + (canSouth ? 2 : 0) + (canNorth ? 1 : 0);
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return hex[b];
    }
}
