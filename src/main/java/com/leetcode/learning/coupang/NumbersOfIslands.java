package com.leetcode.learning.coupang;

public class NumbersOfIslands {
    class Solution {
        /**
         * Given a 2D grid map of '1's (land) and '0's (water), count the number of islands.
         * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
         * You may assume all four edges of the grid are all surrounded by water.
         * @param grid 2D grid map
         * @return number of islands
         */
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int rows = grid.length;
            int cols = grid[0].length;
            int islands = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        islands++;
                        dfs(grid, i, j);
                    }
                }
            }
            return islands;
        }

        /**
         * This is a Depth-First Search (DFS) function that traverses a 2D grid. It takes a grid and coordinates (i, j) as input, and:
         * Checks if the current cell is within the grid boundaries and is a '1' (land).
         * If so, marks the current cell as '0' (water) to avoid revisiting it.
         * Recursively calls itself for the adjacent cells (up, down, left, right).
         * This function is used to "sink" an island in the grid, effectively counting it as visited.
         * @param grid 2D grid map
         * @param i
         * @param j
         */
        private void dfs(char[][] grid, int i, int j) {
            int rows = grid.length;
            int cols = grid[0].length;
            if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}
