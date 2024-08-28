package com.leetcode.learning.matrix;

public class ValidateSudoku {

    static class Solution {

        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                if (!isValidRow(board, i) || !isValidColumn(board, i)) {
                    return false;
                }
            }

            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    if (!isValidSquare(board, i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private char[] getRow(char[][] board, int row) {
            return board[row];
        }
        private char[] getColumn(char[][] board, int column) {
            char[] columnArray = new char[9];
            for (int i = 0; i < 9; i++) {
                columnArray[i] = board[i][column];
            }
            return columnArray;
        }

        private char[][] getSquare(char[][] board, int row, int column) {
            char[][] square = new char[3][3];
            for (int i = 0; i < 3; i++) {
                System.arraycopy(board[row + i], column, square[i], 0, 3);
            }
            return square;
        }

        private boolean isValidateRow2(char[] row) {
            // Initialize the used array
            // used[i] = 1 means the number i is used
            boolean[] used = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (row[i] != '.' && !used[row[i] - '0']) {
                    used[row[i] - '0'] = true;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isValidateColumn2(char[] column) {
            boolean[] used = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (column[i] != '.' && !used[column[i] - '0']) {
                    used[column[i] - '0'] = true;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isValidateSquare2(char[][] square) {
            boolean[] used = new boolean[10];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (square[i][j] != '.' && !used[square[i][j] - '0']) {
                        used[square[i][j] - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValidRow(char[][] board, int row) {
            // Initialize the used array
            // used[i] = 1 means the number i is used
            // used[i] = 0 means the number i is not used
            boolean[] used = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (board[row][i] != '.' && !used[board[row][i] - '0']) {
                    used[board[row][i] - '0'] = true;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isValidColumn(char[][] board, int column) {
            boolean[] used = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (board[i][column] != '.' && !used[board[i][column] - '0']) {
                    used[board[i][column] - '0'] = true;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isValidSquare(char[][] board, int row, int column) {
            boolean[] used = new boolean[10];
            for (int i = row; i < row + 3; i++) {
                for (int j = column; j < column + 3; j++) {
                    if (board[i][j] != '.' && !used[board[i][j] - '0']) {
                        used[board[i][j] - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

    }
}
