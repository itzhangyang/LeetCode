package com.leetcode.learning.coupang.cheapestflightswithinkstops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    public List<Integer> nodes;
    public List<Edge> edges;

    public Graph(int n) {
        nodes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodes.add(i);
        }
        edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public int getLowestCost(int src, int dst, int k) {
        // The lowest cost from src to each node
        int[] costs = new int[nodes.size()];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        // Iterate k times
        for (int i = 0; i <= k; i++) {
            // Copy costs to temp
            int[] temp = Arrays.copyOf(costs, costs.length);

            // Update temp
            for (Edge edge : edges) {
                if (costs[edge.from] != Integer.MAX_VALUE
                        && costs[edge.from] + edge.weight < temp[edge.to]) {
                    temp[edge.to] = costs[edge.from] + edge.weight;
                }
            }
            // Update costs
            costs = temp;
        }

        // Return the lowest cost from src to dst
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
