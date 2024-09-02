package com.leetcode.learning.coupang.glassdoor.detectcycleingraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Graph graph = new Graph(prerequisites);
            for (int i =0; i<numCourses;i++) {
                if(!graph.dfs(i)){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }
}
