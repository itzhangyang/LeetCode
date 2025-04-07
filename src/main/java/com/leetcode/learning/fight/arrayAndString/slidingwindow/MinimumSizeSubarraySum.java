package com.leetcode.learning.fight.arrayAndString.slidingwindow;

/**
 * Leet code 209. Minimum Size Subarray Sum
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // Add the current element to the sum
            sum += nums[i];

            // Shrink the window until the sum is less than s
            while (sum >= s) {
                // Update the result
                result = Math.min(result, i - left + 1);

                // Subtract the leftmost element from the sum
                sum -= nums[left++];

                // Move the left pointer to the right
            }
        }

        // Return the result
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
