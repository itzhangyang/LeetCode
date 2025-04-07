package com.leetcode.notes.arrayandstring.longestcommonprefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            // 如果字符串数组为空，返回空字符串
            return "";
        }
        // 以第一个字符串为基准
        String prefix = strs[0];
        int count = strs.length;
        // 从第二个字符开始遍历
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            // 如果没有公共前缀，直接返回
            if (prefix.isEmpty()) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        // 比较两个字符串的字符
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
