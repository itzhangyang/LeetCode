package com.leetcode.learning.coupang;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    static class Solution{
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> words=new HashSet<>(wordDict);
            // canBeFormed[i] represents if s[0...i] can be formed by dict
            boolean[] canBeFormed = new boolean[s.length() + 1];
            canBeFormed[0] = true;// This will not be used
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (canBeFormed[j] && words.contains(s.substring(j, i))) {
                        canBeFormed[i] = true;
                        break;
                    }
                }
            }
            return canBeFormed[s.length()];
        }
    }
}
