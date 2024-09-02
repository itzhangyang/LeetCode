package com.leetcode.learning.coupang.glassdoor;

public class ValidateIPAddress {
    static class Solution {

        public String validIPAddress(String IP) {
            if (IP == null || IP.isEmpty()) {
                return "Neither";
            }
            if (IP.contains(".")) {
                if (validateIPv4(IP)) {
                    return "IPv4";
                } else {
                    return "Neither";
                }
            } else if (IP.contains(":")) {
                if (validateIPv6(IP)) {
                    return "IPv6";
                } else {
                    return "Neither";
                }
            }
            return "Neither";
        }

        private boolean validateIPv4(String IP) {
            if(IP.charAt(IP.length()-1) == '.') {
                return false;
            }
            String[] parts = IP.split("\\.");
            if (parts.length != 4) {
                return false;
            }
            for (String part : parts) {
                if (part.isEmpty() || part.length() > 3) {
                    return false;
                }
                if (part.charAt(0) == '0' && part.length() > 1) {
                    return false;
                }
                for (char c : part.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        return false;
                    }
                }
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
            }
            return true;
        }

        private boolean validateIPv6(String IP) {
            if(IP.charAt(IP.length()-1) == ':') {
                return false;
            }
            String[] parts = IP.split(":");
            if (parts.length != 8) {
                return false;
            }
            for (String part : parts) {
                if (part.isEmpty() || part.length() > 4) {
                    return false;
                }
                for (char c : part.toCharArray()) {
                    if (!Character.isDigit(c) && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}

