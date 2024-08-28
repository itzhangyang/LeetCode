package com.leetcode.learning.slidingwindow;

public class MinimumSizeSubarraySum {
    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            // Initialize the two pointers
            // left pointer points to the first element
            int left = 0;
            // right pointer points to the first element(This is different from the(Two Pointers) TwoSum2.java)
            int right = 0;
            // Initialize the sum and the minimum length
            int sum = 0;
            int minLen = Integer.MAX_VALUE;
            while (right < nums.length) {
                sum += nums[right];
                // If the sum is greater than or equal to the target, move the left pointer
                while (sum >= target) {
                    minLen = Math.min(minLen, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
                // Move the right pointer
                right++;
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }
}
