package com.leetcode.learning.dc.quicksort;

import java.util.Arrays;

/**
 * Quick Sort
 */
public class Solution {
    public int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
        return nums;
    }

    /**
     * Partition the array into 3 parts
     * - smaller than pivot
     * - equal to pivot
     * - larger than pivot
     * @param nums the input array
     * @param left The left index
     * @param right The right index
     * @return The pivot index
     */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            if (nums[i] < pivot) {
                i++;
            } else if (nums[j] > pivot) {
                j--;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        nums[left] = nums[j];
        nums[j] = pivot;
        return j;
    }
}
