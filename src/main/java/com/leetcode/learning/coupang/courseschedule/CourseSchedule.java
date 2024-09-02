package com.leetcode.learning.coupang.courseschedule;

public class CourseSchedule {
    static class Solution{
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Graph graph = new Graph(prerequisites);
            for(int i = 0; i < numCourses; i++){
                if(!graph.dfs(i, new boolean[numCourses])){
                    return false;
                }
            }
            return true;
        }
    }
}
