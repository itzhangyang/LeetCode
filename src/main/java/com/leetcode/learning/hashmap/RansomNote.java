package com.leetcode.learning.hashmap;


import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    static class Solution {

        public boolean canConstruct(String ransomNote, String magazine) {
            for (Map.Entry<Character, Integer> entry : getCharCountMap(ransomNote).entrySet()) {
                if (entry.getValue() > getCharCountMap(magazine).getOrDefault(entry.getKey(), 0)) {
                    return false;
                }
            }
            return true;
        }

        Map<Character, Integer> getCharCountMap(String s) {
            if(s==null || s.isEmpty()) {
                return new HashMap<>();
            }
            Map<Character, Integer> charCountMap = new HashMap<>();
            for(char c : s.toCharArray()) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
            return charCountMap;
        }
    }
}
