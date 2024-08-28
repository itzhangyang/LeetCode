package com.leetcode.learning.arrays;

public class RemoveDuplicatesFromSortedArray   {
    static class Solution {

        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int i = 0;
            // Traverse the array and compare the current element with the previous element
            // In a sorted array, duplicate elements will be adjacent to each other
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            // The length of the array is the index of the last element + 1
            return i + 1;
        }
    }

}
