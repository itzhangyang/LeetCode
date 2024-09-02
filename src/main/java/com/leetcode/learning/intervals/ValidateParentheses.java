package com.leetcode.learning.intervals;

import java.util.List;
import java.util.Stack;

/**
 * Leet code 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 */
public class ValidateParentheses {

    static class Solution {

        public boolean isValid(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }
            char[] chars = s.toCharArray();
            List<Character> opens = List.of('(', '[', '{');
            List<Character> closes = List.of(')', ']', '}');
            Stack<Character> stack = new Stack<>();
            for (char c : chars) {
                if (opens.contains(c)) {
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
