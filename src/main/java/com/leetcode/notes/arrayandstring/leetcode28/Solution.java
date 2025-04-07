package com.leetcode.notes.arrayandstring.leetcode28;

/**
 * Leetcode 28:
 * Find out the first index of the substring in the string.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return -1;
        }

        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            for (; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
}
