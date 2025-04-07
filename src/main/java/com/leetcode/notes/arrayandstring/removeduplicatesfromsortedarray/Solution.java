package com.leetcode.notes.arrayandstring.removeduplicatesfromsortedarray;

/**
 * 给你一个有序数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必顶要在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 快慢指针的做法
 */
public class Solution {
    public int   removeDuplicatesFromSortedArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
