package com.leetcode.learning.coupang.groupanagrams;

import java.util.*;

/**
 * Leet code 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class GroupAnagrams {
    static class Solution {
        /**
         * Groups the anagrams together
         * Time complexity: O(n * m * log(m))
         * Space complexity: O(n * m)
         * @param strs input strings
         * @return grouped anagrams
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            // Create a map to store the strings with the same key
            // The key is the string with the characters sorted
            // The value is the list of strings with the same key
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                // Sort the characters
                Arrays.sort(chars);
                // Create a key from the sorted characters
                String key = new String(chars);
                // Add the string to the list of strings with the same key
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }
    }
}
