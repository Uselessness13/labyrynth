package lol.kek;

import java.util.List;

public class Board {
    private Cell[][] cells;

    public Board(int numW) {
        cells = new Cell[numW * 2 + 1][numW * 2 + 1];
//
//        for (Cell[] i : cells) {
//            for (Cell j : i) {
//                j = new Cell(false, false, false, false);
//            }
//
//        }

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = new Cell(false, false, false, false);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void encrypt() {
        System.out.println("Encrypt for board");
        System.out.println(cells.length);
        System.out.println(cells[0].length);
        StringBuilder result = new StringBuilder();
        for (Cell[] i : cells) {
            for (Cell j : i) {
                result.append(j.encrypt()+ "  ");
            }
            result.append("\n");
        }
        System.out.println(result+"\n\n");
    }

}
