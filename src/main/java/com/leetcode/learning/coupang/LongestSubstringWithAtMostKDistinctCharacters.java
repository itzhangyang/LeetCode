package com.leetcode.learning.coupang;

public class LongestSubstringWithAtMostKDistinctCharacters {
    static class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int[] count = new int[256];
            int distinctCharCount = 0;
            int left = 0;
            int result = 0;

            for (int right = 0; right < s.length(); right++) {
                char rightChar = s.charAt(right);
                if (count[rightChar] == 0) {
                    distinctCharCount++;
                }
                count[rightChar]++;

                while (distinctCharCount > k) {
                    char leftChar = s.charAt(left);
                    count[leftChar]--;
                    if (count[leftChar] == 0) {
                        distinctCharCount--;
                    }
                    left++;
                }

                result = Math.max(result, right - left + 1);
            }

            return result;
        }
    }
}
