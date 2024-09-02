package com.leetcode.learning.design.lfu;

public class Node {

    public final int key;
    public int value;
    public int frequency;
    public Node next;
    public Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency=0;
    }

    public void incrementFrequency() {
        this.frequency++;
    }
}
