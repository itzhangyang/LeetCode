package com.leetcode.learning.coupang.courseschedule;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule1 {
    static class Solution{
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            for(int i = 0; i < numCourses; i++){
                if(!dfs(prerequisites, i, new boolean[numCourses])){
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int[][] prerequisites, int node, boolean[] visited) {
            if(visited[node]){
                return false;
            }
            visited[node] = true;
            List<Integer> adjacentNodes = getAdjacentNodes(prerequisites, node);
            for (int adjacentNode : adjacentNodes) {
                if (!dfs(prerequisites, adjacentNode, visited)) {
                    return false;
                }
            }
            visited[node] = false;
            return true;
        }

        private List<Integer> getAdjacentNodes(int[][] prerequisites, int node){
            List<Integer> adjacentNodes = new ArrayList<>();
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == node) {
                    adjacentNodes.add(prerequisite[0]);
                }
            }
            return adjacentNodes;
        }
    }
}
