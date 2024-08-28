package com.leetcode.learning.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    static class Solution {

        public List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            for (int i = 0; i < nums.length; i++) {
                int start = nums[i];
                // Find the consecutive numbers
                while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                    i++;
                }
                // If the start number is not equal to the current number, add the range
                if (start != nums[i]) {
                    result.add(start + "->" + nums[i]);
                } else {
                    // If the start number is equal to the current number, add the number
                    result.add(start + "");
                }
            }
            return result;
        }
    }
}
