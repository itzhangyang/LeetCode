package com.leetcode.learning.intervals;

import java.util.Stack;

public class ValidateParentheses {

    static class Solution {

        public boolean isValid(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    // Push the left parentheses to the stack
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if (c == ')' && top != '(') {
                        return false;
                    }
                    if (c == ']' && top != '[') {
                        return false;
                    }
                    if (c == '}' && top != '{') {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
