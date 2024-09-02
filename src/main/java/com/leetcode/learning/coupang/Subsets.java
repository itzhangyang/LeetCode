package com.leetcode.learning.coupang;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 */
public class Subsets {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            // Empty subsets is always a subsets
            subsets.add(new ArrayList<>());
            for (int num : nums) {
                System.out.println("Processing Num: " + num);
                // For each number, create a new list to store the new subsets
                List<List<Integer>> currentSubsets = new ArrayList<>();
                // For each subsets in the subsets, add the current number to the subsets
                for (List<Integer> subset : subsets) {
                    System.out.println("Select Subset: " + subset);
                    List<Integer> newSubset = new ArrayList<>(subset);
                    newSubset.add(num);
                    System.out.println("Create New Subset =  " + subset + " + " + num);
                    currentSubsets.add(newSubset);
                    System.out.println("Current Subsets-" +num + ": "+ currentSubsets);
                }
                subsets.addAll(currentSubsets);
                System.out.println("Subsets: " + subsets);
            }

            return subsets;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}
