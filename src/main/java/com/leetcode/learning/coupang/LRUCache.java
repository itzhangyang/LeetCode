package com.leetcode.learning.coupang;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    Node head;
    Node tail;
    int capacity;
    int size = 0;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        System.out.println("get " + key);
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // Move the node to the head
            // Remove the node from the list
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    private void moveToHead(Node node) {
        // Move the node to the head
        // Remove the node from the list
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;

        // Add the node to the head
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeTail() {
        Node toRemove = tail.prev;
        System.out.println("remove " + toRemove.key);
        map.remove(toRemove.key);
        Node prev = toRemove.prev;
        prev.next = tail;
        tail.prev = prev;
        size--;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            System.out.println("update " + key + " " + value);
            Node node = map.get(key);
            moveToHead(node);
        } else {
            System.out.println("put " + key + " " + value);
            if (size == capacity) {
                removeTail();
            }
            Node node = new Node();
            node.key = key;
            node.value = value;

            Node headNext = head.next;
            node.next = headNext;
            headNext.prev = node;
            node.prev = head;
            head.next = node;
            map.put(key, node);
            size++;
        }
    }

    void print() {
        Node current = head.next;
        while (current != tail) {
            System.out.println(current.key + " " + current.value);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        // Input
        // ["put","put","get","put","get","put","get","get","get"]
        // [[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        cache.put(1, 1);
        cache.print();
        cache.put(2, 2);
        cache.print();
        cache.get(1);
        cache.print();
        cache.put(3, 3);
        cache.print();
        cache.get(2);
        cache.print();
        cache.put(4, 4);
        cache.print();
        cache.get(1);
        cache.print();
        cache.get(3);
        cache.print();
        cache.get(4);
        cache.print();
    }
}
