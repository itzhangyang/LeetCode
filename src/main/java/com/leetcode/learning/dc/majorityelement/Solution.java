package com.leetcode.learning.dc.majorityelement;

public class Solution {
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int leftMajority = majorityElement(nums, left, mid);
        int rightMajority = majorityElement(nums, mid + 1, right);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        int leftCount = countInRange(nums, leftMajority, left, right);
        int rightCount = countInRange(nums, rightMajority, left, right);

        return leftCount > rightCount ? leftMajority : rightMajority;
    }

    private int countInRange(int[] nums, int num, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
