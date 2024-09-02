package com.leetcode.learning.coupang.bsf;


import java.util.*;

public class Graph {
    public int[] nodes;
    public Map<Integer, List<Integer>> adjList;

    public Graph(int n) {
        nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
    }


    public void bfs(int start) {
        Queue<Integer> queue = new java.util.LinkedList<>();
        // The visited set is used to avoid visiting the same node multiple times
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        StringBuilder sb = new StringBuilder();
        sb.append("start: ");
        while (!queue.isEmpty()) {
            // Poll the node from the head of the queue and print it
            int node = queue.poll();
            sb.append(node).append(" ");
            // Put the adjacent nodes of the polled node to the queue
            // The visited set is used to avoid visiting the same node multiple times
            int[] adjacentNodes = getAdjacentNodes(node);
            for (int adjacentNode : adjacentNodes) {
                if (!visited.contains(adjacentNode)) {
                    queue.add(adjacentNode);
                    visited.add(adjacentNode);
                }
            }
        }
        System.out.println(sb.toString());
    }
    public void dfs(int start, Set<Integer> visited) {
        visited.add(start);
        System.out.print(start + " ");

        for (int neighbor : adjList.getOrDefault(start, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public void dfs2(int start) {
        Stack<Integer> stack = new Stack<>();
        // The visited set is used to avoid visiting the same node multiple times
        Set<Integer> visited = new HashSet<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                System.out.println(node);
                visited.add(node);
            }

            for (int neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
    }

    private int[] getAdjacentNodes(int node) {
        return adjList.get(node).stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.adjList = new HashMap<>();
        graph.adjList.put(0, Arrays.asList(1, 2));
        graph.adjList.put(1, Arrays.asList(0, 2, 3));
        graph.adjList.put(2, Arrays.asList(0, 1, 3));
        graph.adjList.put(3, Arrays.asList(1, 2, 4));
        graph.adjList.put(4, Collections.singletonList(3));
        System.out.println("BFS");
        graph.bfs(0);
        System.out.println("DFS");
        graph.dfs(0, new HashSet<>());
        System.out.println("DFS2");
        graph.dfs2(0);
    }
}
