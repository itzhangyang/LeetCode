package com.leetcode.learning.coupang;


public class IslandCounter {

    public static class Grid {
        private Cell[][] cells;

        public Grid(char[][] gridData) {
            this.cells = new Cell[gridData.length][gridData[0].length];
            for (int i = 0; i < gridData.length; i++) {
                for (int j = 0; j < gridData[0].length; j++) {
                    cells[i][j] = new Cell(gridData[i][j]);
                }
            }
        }

        public Cell[][] getCells() {
            return cells;
        }

        public boolean isEmpty() {
            return cells.length == 0;
        }
    }

    public static class Cell {
        private char state;

        public Cell(char state) {
            this.state = state;
        }

        public boolean isLand() {
            return state == '1';
        }

        public void markAsWater() {
            state = '0';
        }
    }


    private Grid grid;

    public IslandCounter(Grid grid) {
        this.grid = grid;
    }

    public int countIslands() {
        if (grid == null || grid.isEmpty()) {
            return 0;
        }

        int islandCount = 0;
        int rows = grid.getCells().length;
        int cols = grid.getCells()[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = grid.getCells()[i][j];
                if (cell.isLand()) {
                    islandCount++;
                    new Island(grid, cell).sink();
                }
            }
        }
        return islandCount;
    }





    public static class Island {
        private Grid grid;
        private Cell cell;

        public Island(Grid grid, Cell cell) {
            this.grid = grid;
            this.cell = cell;
        }

        public void sink() {
            if (cell.isLand()) {
                cell.markAsWater();
                for (Cell adjacentCell : getAdjacentCells()) {
                    new Island(grid, adjacentCell).sink();
                }
            }
        }

        private Cell[] getAdjacentCells() {
            int row = getRow();
            int col = getCol();
            Cell[] adjacentCells = new Cell[4];

            if (row > 0) {
                adjacentCells[0] = grid.getCells()[row - 1][col];
            }
            if (row < grid.getCells().length - 1) {
                adjacentCells[1] = grid.getCells()[row + 1][col];
            }
            if (col > 0) {
                adjacentCells[2] = grid.getCells()[row][col - 1];
            }
            if (col < grid.getCells()[0].length - 1) {
                adjacentCells[3] = grid.getCells()[row][col + 1];
            }

            return adjacentCells;
        }

        private int getRow() {
            for (int i = 0; i < grid.getCells().length; i++) {
                for (int j = 0; j < grid.getCells()[0].length; j++) {
                    if (grid.getCells()[i][j] == cell) {
                        return i;
                    }
                }
            }
            return -1;
        }

        private int getCol() {
            for (int i = 0; i < grid.getCells().length; i++) {
                for (int j = 0; j < grid.getCells()[0].length; j++) {
                    if (grid.getCells()[i][j] == cell) {
                        return j;
                    }
                }
            }
            return -1;
        }
    }
}
