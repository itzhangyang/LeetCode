package com.leetcode.learning.coupang;

/**
 * Leet Code 394. Decode String
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */
public class DecodeString {
    static class Solution {
        /**
         * Decodes the given string
         * Time complexity: O(n)
         * Space complexity: O(n)
         * @param s input string
         * @return decoded string
         */
        public String decodeString(String s) {
            StringBuilder result = new StringBuilder();
            char[] chars = s.toCharArray();
            int i = 0;
            while (i < s.length()) {
                char c = chars[i];
                // If the character is a digit, then extract the number
                // and decode the string inside the square brackets
                if (Character.isDigit(c)) {
                    // Extract the number
                    int start = i;
                    while (Character.isDigit(s.charAt(i))) {
                        i++;
                    }
                    int count = Integer.parseInt(s.substring(start, i));

                    // Find out the substring inside the square brackets
                    // Open means the num of opened symbol
                    int open = 1;
                    // close means the num of closed symbol
                    int close = 0;
                    int j = i + 1;
                    // only when the open = close, we found the sub string
                    while (open != close) {
                        if (s.charAt(j) == '[') {
                            open++;
                        } else if (s.charAt(j) == ']') {
                            close++;
                        }
                        j++;
                    }
                    // Decode the substring inside the square brackets
                    String sub = decodeString(s.substring(i + 1, j - 1));

                    // Append the decoded string to the result
                    String stringToBeRepeated = decodeString(s.substring(i + 1, j - 1));
                    if (count > 0) {
                        for (int m=1; m<=count; m++) {
                            result.append(stringToBeRepeated);
                        }
                    }
                    i = j;
                } else {
                    // If the character is not a digit, then append it to the result
                    result.append(c);
                    i++;
                }
            }
            return result.toString();
        }
    }
}
