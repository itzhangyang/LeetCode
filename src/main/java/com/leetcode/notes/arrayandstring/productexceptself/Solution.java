package com.leetcode.notes.arrayandstring.productexceptself;

/**
 * LeetCode 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1。
 * 返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 不能使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：在常数空间复杂度内完成此题
 * 解法：左右乘积列表
 * 1. 计算左侧乘积, 从左到右遍历数组, 计算每个元素左侧的乘积
 * 2. 计算右侧乘积, 从右到左遍历数组, 计算每个元素右侧的乘积
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // 计算左侧乘积
        int left = 1;
        // res[i] 表示 nums[0,i-1] 元素的乘积
        // res[0] = 1, 因为 0 之前没有元素
        for (int i = 0; i < n; i++) {
            res[i] = left;
            left *= nums[i];
        }
        // 计算右侧乘积
        // right 表示 nums[i+1,n-1] 元素的乘积
        // res[i] = res[i] * right
        // 因为 res[i] 表示 nums[0,i-1] 元素的乘积
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
