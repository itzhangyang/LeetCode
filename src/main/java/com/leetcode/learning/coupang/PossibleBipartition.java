package com.leetcode.learning.coupang;

/**
 * This Java method determines whether it's possible to divide a group of N people into two groups
 * such that no two people who dislike each other are in the same group.
 * The dislikes array contains pairs of people who dislike each other.
 * The method uses a coloring approach,
 * where each person is initially assigned a unique color,
 * and then iteratively updates the colors based on the dislikes.
 * If at any point two people with the same color are found to dislike each other, the method returns false.
 * Otherwise, it returns true, indicating that a bipartition is possible.
 */
public class PossibleBipartition {
    static class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            // Step 1: Create a graph
            Graph graph = new Graph();

            // Step 2: Add edges to the graph
            for (int[] dislike : dislikes) {
                graph.addEdge(dislike[0], dislike[1]);
            }

            // Step 3: Initialize colors array
            // 0: uncolored, 1: color 1, -1: color -1
            int[] colors = new int[N+1];

            // Step 4: Iterate through nodes and color them
            for (int i = 0; i < N; i++) {
                if (colors[i] == 0) { // node not colored yet
                    if (!colorNode(graph, colors, i, 1)) {
                        return false; // coloring failed
                    }
                }
            }

            // Step 6: Check if all nodes have been colored
            return true; // all nodes colored
        }

        /*This method attempts to color a node in a graph with a given color.
        If the node is already colored, it checks if the color matches the given color.
         If not, it returns false. Otherwise, it assigns the color to the node and recursively attempts to color its neighbors with the opposite color.
          If any neighbor cannot be colored, it returns false.
           If all neighbors are successfully colored, it returns true.
        */
        private boolean colorNode(Graph graph, int[] colors, int node, int color) {
            // Step 5: Color a node
            if (colors[node] != 0) { // node already colored
                // If the node is already colored with the same color, return false
                // This means that two people with the same color dislike each other
                return colors[node] == color; // check if correct color
            }
            colors[node] = color; // assign color
            for (int neighbor : graph.getNeighbors(node)) {
                if (!colorNode(graph, colors, neighbor, -color)) {
                    return false; // neighbor cannot be colored with opposite color
                }
            }
            return true; // node colored successfully
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int N = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        boolean result = solution.possibleBipartition(N, dislikes);
        System.out.println(result);
    }
}
