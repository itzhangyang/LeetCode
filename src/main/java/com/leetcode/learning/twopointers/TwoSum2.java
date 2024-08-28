package com.leetcode.learning.twopointers;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 */
public class TwoSum2 {
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            // Initialize two pointers
            // Pointer i: points to the first element
            int i = 0;
            // Pointer j: points to the last element
            int j = numbers.length - 1;
            while (i < j) {
                // If numbers[i] + numbers[j] == target, return the indices
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    return new int[]{i + 1, j + 1};
                } else if (sum < target) {
                    // If the sum is less than the target, increment i
                    i++;
                } else {
                    // If the sum is greater than the target, decrement j
                    j--;
                }
            }
            return new int[]{-1, -1};
        }
    }
}
