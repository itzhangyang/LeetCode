package com.leetcode.notes.arrayandstring.canjump;

public class Solution {
    public boolean canJump(int[] nums){
        int n = nums.length; // 数组的长度
        int farthest = 0; // 当前能到达的最远位置

        for (int i = 0; i < n - 1; i++) {
            int currentJump = i + nums[i]; // 当前索引位置能跳到的最远位置
            farthest = Math.max(farthest, currentJump); // 更新能到达的最远位置

            // 如果当前能到达的最远位置小于等于当前索引，说明无法继续前进
            if (farthest <= i) {
                return false;
            }
        }

        // 检查能到达的最远位置是否至少到达最后一个位置
        return farthest >= n - 1;
    }
}
