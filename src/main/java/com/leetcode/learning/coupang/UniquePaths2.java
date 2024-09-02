package com.leetcode.learning.coupang;

import java.util.List;

/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * An obstacle and space are marked as 1 or 0 respectively in grid.
 * A path that the robot takes cannot include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths2 {

    static class Solution {
        /**
         * This method calculates the number of unique paths that the robot can take to reach the bottom-right corner.
         * The robot can only move either down or right at any point in time.
         * An obstacle and space are marked as 1 or 0 respectively in grid.
         * A path that the robot takes cannot include any square that is an obstacle.
         *
         * @param obstacleGrid a 2D array representing the grid with obstacles and spaces
         *                     where 1 represents an obstacle and 0 represents a space
         * @return the number of possible unique paths that the robot can take to reach the bottom-right corner
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int rowsNum = obstacleGrid.length;
            int columnsNum = obstacleGrid[0].length;
            // Create a 2D array to store the number of unique paths to each cell(from top-left to the current cell)
            // Initialize the array with zeros
            int[][] pathsNumFromStart = new int[rowsNum][columnsNum];
            // Initialize the first cell
            pathsNumFromStart[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
            // Initialize the first row
            // For cells in the first row, the number of paths is equal to the number of paths to the previous cell
            // Because the robot can only move right or down, which means there is only one way to reach the  cells in the first row (move forward right)
            // If there is no obstacle in the previous cell, then the number of paths to the current cell is equal to the number of paths to the previous cell(1)
            // If there is an obstacle in the previous cell, then the number of paths to the current cell is 0
            for (int i = 1; i < rowsNum; i++) {
                // If there is an obstacle, set the number of paths to 0
                pathsNumFromStart[i][0] = obstacleGrid[i][0] == 0 ? pathsNumFromStart[i - 1][0] : 0;
            }
            // Initialize the first column
            // For cells in the first column, the number of paths is equal to the number of paths to the previous cell
            // Because the robot can only move right or down, which means there is only one way to reach the  cells in the first column (move forward down)
            // If there is no obstacle in the previous cell, then the number of paths to the current cell is equal to the number of paths to the previous cell(1)
            // If there is an obstacle in the previous cell, then the number of paths to the current cell is 0
            for (int j = 1; j < columnsNum; j++) {
                pathsNumFromStart[0][j] = obstacleGrid[0][j] == 0 ? pathsNumFromStart[0][j - 1] : 0;
            }

            // Fill in the rest of the cells
            for (int i = 1; i < rowsNum; i++) {
                for (int j = 1; j < columnsNum; j++) {
                    if (obstacleGrid[i][j] == 0) {
                        // The path to the current cell is the sum of the paths to the cell above and the cell to the left
                        pathsNumFromStart[i][j] = pathsNumFromStart[i - 1][j] + pathsNumFromStart[i][j - 1];
                    }
                }
            }
            return pathsNumFromStart[rowsNum - 1][columnsNum - 1];
        }
    }
}
