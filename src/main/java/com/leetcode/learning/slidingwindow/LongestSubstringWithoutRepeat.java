package com.leetcode.learning.slidingwindow;

public class LongestSubstringWithoutRepeat {

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            // Initialize the two pointers
            // left pointer points to the first element
            int left = 0;
            // right pointer points to the first element(This is different from the(Two Pointers) TwoSum2.java)
            int right = 0;
            // Use an array to store the characters in the string
            // The index of the array is the ASCII code of the character
            // The value of the array is 1 if the character exists, otherwise 0
            int[] charExistenceMap = new int[256];
            int max = 0;
            while (right < s.length()) {
                // If the character does not exist, mark it as 1 and move the right pointer
                if (charExistenceMap[s.charAt(right)] == 0) {
                    charExistenceMap[s.charAt(right)] = 1;
                    max = Math.max(max, right - left + 1);
                    right++;
                } else {
                    // If the character is in the set, move the left pointer
                    charExistenceMap[s.charAt(left)] = 0;
                    left++;
                }
            }
            return max;
        }
    }
}
