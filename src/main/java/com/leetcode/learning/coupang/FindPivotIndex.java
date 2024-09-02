package com.leetcode.learning.coupang;

/**
 * LeetCode 724. Find Pivot Index
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * Example 1:
 * Input: nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * Example 2:
 * Input: nums = [1, 2, 3]
 * Output: -1
 */
public class FindPivotIndex {
    static class Solution {
        /**
         * Finds the pivot index of the given array
         * Time complexity: O(n)
         * Space complexity: O(1)
         * @param nums input array
         * @return pivot index
         */
        public int pivotIndex(int[] nums) {
            int sum = 0;
            // Calculate the sum of all the elements in the array
            for (int num : nums) {
                sum += num;
            }
            // Calculate the left sum and compare it with the right sum
            int leftSum = 0;
            for (int i = 0; i < nums.length; i++) {
                // If the left sum is equal to the right sum, then return the index
                if (leftSum == sum - leftSum - nums[i]) {
                    return i;
                }
                // Update the left sum
                leftSum += nums[i];
            }

            return -1;
        }
    }
}
