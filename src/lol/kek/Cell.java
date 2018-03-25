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
        String b = (canEast ? "1" : "0") + (canWest ? "1" : "0") + (canSouth ? "1" : "0") + (canNorth ? "1" : "0");
        int binnum, rem;
        binnum = Integer.parseInt(b);
        String hexdecnum="";

        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(binnum>0)
        {
            rem = binnum%16;
            hexdecnum = hex[rem] + hexdecnum;
            binnum = binnum/16;
        }
        return hexdecnum.toString().toCharArray()[0];
    }
}
