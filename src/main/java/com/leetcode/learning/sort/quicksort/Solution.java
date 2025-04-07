package com.leetcode.learning.sort.quicksort;

public class Solution {
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    /**
     * 分区函数, 返回分区点的下标
     * We choose the last element as the pivot
     * 1. Traverse the array from the leftmost element to the rightmost element
     * 2. Compare each element with the pivot, if the element is less than the pivot, swap the element with the counter element
     * @param nums The array to be sorted
     * @param left The left boundary of the array
     * @param right The right boundary of the array
     * @return The index of the pivot
     */
    private int partition(int[] nums, int left, int right) {
        // Choose the last element as the pivot
        int pivot = right;
        // Counter is used to record the position of the element that is less than the pivot
        int counter = left;

        for (int i = left; i < right; i++) {
            // Compare each element with the pivot
            // If the element is less than the pivot, swap the element with the counter element
            if (nums[i] < nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[counter];
                nums[counter] = temp;
                counter++;
            }
        }
        // Swap the pivot with the counter element
        int temp = nums[pivot];
        nums[pivot] = nums[counter];
        nums[counter] = temp;
        return counter;
    }


}
