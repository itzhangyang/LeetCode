package com.leetcode.learning.twopointers;

public class ValidatePalindrome {

    static class Solution {
        public boolean isPalindrome(String s) {
            // Initialize the two pointers
            // left pointer points to the first character
            int left = 0;
            // right pointer points to the last character
            int right = s.length() - 1;
            while (left < right) {
                // Skip non-alphanumeric characters
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }
                // Compare the characters
                if (left < right) {
                    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    left++;
                    right--;
                }
            }
            return true;
        }
    }
}
