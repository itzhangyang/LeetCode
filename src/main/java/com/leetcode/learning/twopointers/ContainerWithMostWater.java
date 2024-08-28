package com.leetcode.learning.twopointers;

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are  from:
 * -(i, 0)
 * -(i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater    {
    static class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            // Initialize two pointers
            // Pointer left: points to the first element
            int left = 0;
            // Pointer right: points to the last element
            int right = height.length - 1;
            // Calculate the area of the container formed by the two pointers
            while (left < right) {
                int area = (right - left) * Math.min(height[left], height[right]);
                maxArea = Math.max(maxArea, area);
                // Move the pointer with the smaller height
                // The purpose is to find a larger height to form a larger container
                // Only when the height is larger, the area of the container can be larger
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxArea;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height));
    }
}
