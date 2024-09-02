package com.leetcode.learning.coupang.rangemodule;

public class Range {
    public int left;
    public int right;
    public Range prev;
    public Range next;

    public Range(int left, int right) {
        this.left = left;
        this.right = right;
    }

}
