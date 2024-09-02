package com.leetcode.learning.coupang.glassdoor.detectcycleingraph;

import java.util.*;

public class Graph {
    public List<Edge> edges;
    public List<Integer> nodes;

    public Graph(int[][] prerequisites) {
        edges = new ArrayList<>();
        nodes = new ArrayList<>();
        for (int[] prerequisite:prerequisites) {
            edges.add(new Edge(prerequisite[0],prerequisite[1]));
            if(!nodes.contains(prerequisite[0])) {
                nodes.add(prerequisite[0]);
            }
            if(!nodes.contains(prerequisite[1])) {
                nodes.add(prerequisite[1]);
            }
        }
    }

    public List<Integer> getToNodes(int node){
        List<Integer> result = new ArrayList<>();
        for (Edge edge: edges) {
            if (edge.from == node) {
                result.add(edge.to);
            }
        }
        return result;
    }

    public boolean dfs(int node, boolean[] visited) {
        if (visited[node]) {
            return false;
        }
        visited[node] = true;

        // check if there is a cycle
        for (int neighbor : getToNodes(node)) {
            if (!dfs(neighbor, visited)) {
                return false;
            }
        }
        visited[node] = false;
        return true;
    }

    public boolean dfs(int node) {
        return dfs(node, new boolean[nodes.size()]);
    }

    /**
     * Non-recursive implementation
     * @param node The start node
     * @return whether there is cycle from the node
     */
    public boolean dsf2(int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        boolean[] visited = new boolean[nodes.size()];
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current])  {
                visited[current] = true;
            }
            List<Integer> toNodes = this.getToNodes(node);
            for (int currentNode : toNodes) {
                if (!visited[currentNode]) {
                    stack.push(currentNode);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
