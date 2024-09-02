package com.leetcode.learning.coupang;


public class SearchIn2DMatrix {
    static class Solution {
        /**
         * Search in a 2D matrix
         * Since the matrix is sorted, we can start from the top right corner
         * If the target number is greater than the current number, move down to the next row
         * If the target number is less than the current number, move left to the previous column
         * @param matrix 2D matrix
         * @param target target number
         * @return true if the target number is in the matrix
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            // Start from the top right corner
            int row = 0;
            // The last column
            int col = matrix[0].length - 1;
            while (row < matrix.length && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] < target) {
                    row++;
                } else {
                    col--;
                }
            }
            return false;
        }
    }
}
