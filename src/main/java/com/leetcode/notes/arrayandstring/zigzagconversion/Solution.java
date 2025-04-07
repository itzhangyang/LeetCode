package com.leetcode.notes.arrayandstring.zigzagconversion;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                if (j == 0) {
                    sb.append(s.charAt(i));
                }
            }
        }
    }
}
