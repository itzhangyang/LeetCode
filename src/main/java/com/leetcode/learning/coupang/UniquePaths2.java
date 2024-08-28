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
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            // Create a 2D array to store the number of unique paths to each cell(from top-left to the current cell)
            // Initialize the array with zeros
            int[][] dp = new int[m][n];
            // Initialize the first cell
            dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
            // Initialize the first row
            for (int i = 1; i < m; i++) {
                // If there is an obstacle, set the number of paths to 0
                dp[i][0] = obstacleGrid[i][0] == 0 ? dp[i - 1][0] : 0;
            }
            // Initialize the first column
            for (int j = 1; j < n; j++) {
                dp[0][j] = obstacleGrid[0][j] == 0 ? dp[0][j - 1] : 0;
            }
            // Fill in the rest of the cells
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
