package com.leetcode.learning.coupang;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public List<Integer> nodes;
    public List<Edge> edges;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
    public void addEdge(int from, int to) {
        if (!nodes.contains(from)) {
            nodes.add(from);
        }
        if (!nodes.contains(to)) {
            nodes.add(to);
        }
        edges.add( new Edge(from, to));
    }

    List<Integer> getNeighbors(int node) {
        List<Integer> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.from == node) {
                neighbors.add(edge.to);
            } else if (edge.to == node) {
                neighbors.add(edge.from);
            }
        }
        return neighbors;
    }
}
