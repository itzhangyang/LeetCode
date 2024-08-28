package com.leetcode.learning.basic;

public class Fibbonaci {
    public int[] fibbonaci(int n){
        int[] result = new int[n];
        for(int i=0;i<=n;i++){
            result[i]=fibbonaciValue(i);
        }
        return result;

    }

    public int fibbonaciValue(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibbonaciValue(n-1)+fibbonaciValue(n-2);
    }
}
