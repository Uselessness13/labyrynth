package lol.kek;

import java.util.List;

public class Board {
    private Cell[][] cells;

    public Board(int numW) {
        cells = new Cell[numW * 2 + 1][numW * 2 + 1];

        for (Cell[] i : cells) {
            for (Cell j : i) {
                j = new Cell(false,false,false,false);
            }

        }
    }

    public Cell[][] getCells() {
        return cells;
    }

}
