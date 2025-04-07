package com.leetcode.learning.recurrence.powerxn;

public class Solution {
    public int power(int x,int n) {
        // base condition
        if (n == 0) { return 1;}
        if (n == 1) { return x; }
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.power(2, 3));
    }
}
