package com.leetcode.learning.recurrence;

public class Fibonacci
{
    public static int fibonacci(int n) {
        // base case
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // sub problems
        int nMinus1Result = fibonacci(n - 1);
        int nMinus2Result = fibonacci(n - 2);
        // recursive case
        return nMinus1Result + nMinus2Result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}
