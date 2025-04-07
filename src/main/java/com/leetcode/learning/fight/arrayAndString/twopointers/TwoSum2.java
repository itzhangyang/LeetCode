package com.leetcode.learning.fight.arrayAndString.twopointers;

/**
 * Leet code 167. Two Sum II - Input array is sorted
 * Question: <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Leet code</a>
 * Description:
 * Given an array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 */
public class TwoSum2 {
    /**
     * Finds two numbers in a sorted array that add up to a target value
     *
     * @param numbers
     *            sorted array of integers
     * @param target
     *            target value
     * @return two element array with indices of two numbers in the array that add
     *         up to the target. If no such numbers are found, returns array with
     *         two -1 values.
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        // Traverse the array
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            // If the sum is equal to the target, return the indices
            if (sum == target) {
                return new int[] { left, right };
            }
            else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // Return the result
        return new int[] { -1, -1 };
    }

}
