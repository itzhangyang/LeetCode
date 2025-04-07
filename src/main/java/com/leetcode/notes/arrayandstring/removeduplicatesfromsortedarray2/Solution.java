package com.leetcode.notes.arrayandstring.removeduplicatesfromsortedarray2;

/**
 * 给你一个有序数组 nums ，请你原地删除重复出现的元素，使每个元素 最多出现两次 ，
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Initialize the slow pointer
        int slow = 0;
        // Initialize the count of the current element
        int count = 1;
        // Traverse the array
        for (int fast = 1; fast < nums.length; fast++) {
            // If the current element is equal to the previous element
            if (nums[fast] == nums[slow]) {
                // Increment the count
                count++;
                // If the count is less than or equal to 2
                if (count <= 2) {
                    // Move the current element to the slow pointer
                    nums[++slow] = nums[fast];
                }
            } else {
                // If the current element is different from the previous element
                // Move the current element to the slow pointer
                nums[++slow] = nums[fast];
                // Reset the count
                count = 1;
            }
        }
        return slow + 1;
    }

}
