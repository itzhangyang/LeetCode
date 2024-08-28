package com.leetcode.learning.fabonacci;

public class Fibonacci {

        public int fib(int N) {
            if (N <= 1) {
                return N;
            }
            return fib(N - 1) + fib(N - 2);
        }


    /**
     * Dynamic Programming
     *
     * @param N the Nth number
     * @return Fibonacci number
     */
    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

}
