package com.leetcode.learning.recurrence;

public class RecursiveExample1 {

    public static int fibonacci(int n) {
       // base case
        if (n <= 1) {
            return n;
        }
        // recursive case
        int roundNMinus1 = fibonacci(n - 1);
        int roundNMinus2 = fibonacci(n - 2);
        // combine the results
        return roundNMinus1 + roundNMinus2;
    }

    public static int mergeSortComplexity(int n) {
       if (n <=1) {
           return 1;
       }
       return 2 * mergeSortComplexity(n/2) + n;
    }
    // f(n) = (2/n)*sum(f(1),f2),f(3),...,f(n-1)) + n
    public static int example3(int n) {
        if (n <= 1) {
            return 1;
        }
        int sum =0;
        for(int i = 1; i < n-1; i++) {
           sum+=example3(i);
        }
        float twoByN = (float) 2 /n;
        float v = twoByN * sum + n;
        return  (int)v;
    }

    public static int example4(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += result[j];
            }
            result[i] = 2 * sum + i;
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(example3(10));
    }
}
