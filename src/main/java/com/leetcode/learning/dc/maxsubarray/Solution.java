package com.leetcode.learning.dc.maxsubarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int leftMax = maxSubArray(nums, left, mid);
        int rightMax = maxSubArray(nums, mid + 1, right);
        int crossMax = crossMax(nums, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int crossMax(int[] nums, int left, int mid, int right) {
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }

        return leftMax + rightMax;
    }
}
