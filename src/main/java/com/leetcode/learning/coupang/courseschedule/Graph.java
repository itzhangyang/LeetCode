package com.leetcode.learning.coupang.courseschedule;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public List<Integer> nodes;
    public List<Edge> edges;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public Graph(int[][] prerequisites){
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            addEdge(prerequisite[1], prerequisite[0]);
        }
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

    List<Integer> getToNodes(int node) {
        List<Integer> toNodes = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.from == node) {
                toNodes.add(edge.to);
            }
        }
        return toNodes;
    }

    public boolean dfs(int node, boolean[] visited) {
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        for (int neighbor : getToNodes(node)) {
            if (!dfs(neighbor, visited)) {
                return false;
            }
        }
        return true;
    }

}
