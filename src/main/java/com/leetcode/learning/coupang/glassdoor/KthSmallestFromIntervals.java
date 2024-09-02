package com.leetcode.learning.coupang.glassdoor;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of intervals arr[] of size N, the task is to find the Kth smallest element among all the elements within the intervals of the given array.
 * Input : arr[] = {{5, 11}, {10, 15}, {12, 20}}, K =12
 * Output: 13
 * Explanation: Elements in the given array of intervals are: {5, 6, 7, 8, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 17, 18, 19, 20}.
 * Therefore, the Kth(=12th) smallest element is 13.
 * Input: arr[] = {{5, 11}, {10, 15}, {12, 20}}, K = 7
 * Output:10
 *
 */
public class KthSmallestFromIntervals {
    public static void main(String[] args) {
        int[][] arr = {{5, 11}, {10, 15}, {12, 20}};
        int k = 12;
        System.out.println(kthSmallest(arr, k));
    }

    private static int kthSmallest(int[][] intervals, int k) {
        int maxVal = getMaxVal(intervals);
        // Map to store the count of elements in the intervals
        // The key is the element( in the interval) and the value is the count
        Map<Integer, Integer> map = getElementCountMap(intervals);
        // Find the kth smallest element
        int count = 0;
        for (int i = 0; i <= maxVal; i++) {
            if (map.containsKey(i)) {
                count += map.get(i);
                if (count >= k) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static Map<Integer, Integer> getElementCountMap(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        // Count the elements in the intervals
        for (int[] interval : intervals) {
            // Get the elements in the interval (between start and the end of the interval)
            for (int i = interval[0]; i < interval[1]; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return map;
    }

    private static int getMaxVal(int[][] intervals) {
        int maxVal = 0;
        for (int[] interval : intervals) {
            maxVal = Math.max(maxVal, interval[1]);
        }
        return maxVal;
    }
}
