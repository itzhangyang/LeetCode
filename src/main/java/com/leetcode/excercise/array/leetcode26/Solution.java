package com.leetcode.excercise.array.leetcode26;


/**
 * 快慢指针的做法
 * 
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int slow =0;
        int fast =1;
        while(fast<nums.length){
            if(nums[slow] != nums[fast]){
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
