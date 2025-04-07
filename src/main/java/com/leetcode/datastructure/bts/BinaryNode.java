package com.leetcode.datastructure.bts;

public class BinaryNode {
    BinaryNode left;
    BinaryNode right;
    Integer data;

    public BinaryNode(Integer data) {
        this.data = data;
    }
    public BinaryNode(Integer data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
