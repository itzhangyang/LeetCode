package com.leetcode.notes.arrayandstring.lengthoflastword;

public class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        // 去除末尾空格
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        // 计算最后一个单词的长度
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}
