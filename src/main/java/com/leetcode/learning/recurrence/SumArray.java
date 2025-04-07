package com.leetcode.learning.recurrence;

public class SumArray {
    public static int sumArray(int[] arr) {
        return sumArray(arr, 0);
    }

    private static int sumArray(int[] arr, int i) {
        // base case
        if (i == arr.length) {
            return 0;
        }
        // recursive case
        return arr[i] + sumArray(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sumArray(arr));
    }
}
