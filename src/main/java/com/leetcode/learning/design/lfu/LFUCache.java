package com.leetcode.learning.design.lfu;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 460. LFU Cache
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * Implement the LFUCache class:
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if the key exists in the cache. Otherwise, adds the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evicts the least frequently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LFUCache {
    public Map<Integer, Node> cache; // <key, Node>
    Node head ;
    public final int capacity;
    Node tail;
    private int size;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.incrementFrequency();
            Node headNext = head.next;
            if(node.frequency > headNext.frequency) {
                moveToHead(node);
            }
            System.out.println("Get key: " + key + " value: " + node.value);
            printCache();
            return node.value;
        }
        return -1;
    }

    private void moveToHead(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private void removeTail() {
        Node nodeToRemove = tail.prev;
        Node prev = nodeToRemove.prev;
        prev.next = tail;
        tail.prev = prev;
        cache.remove(prev.key);
        size--;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            get(key);
            System.out.println("Update key: " + key + " value: " + value);
            System.out.println("cache: " + cache);
        } else {
            if(size >= capacity) {
                removeTail();
            }
            Node node = new Node(key, value);
            cache.put(key, node);

            Node tailPrev = tail.prev;
            tailPrev.next = node;
            node.prev = tailPrev;
            node.next = tail;
            tail.prev = node;

            size++;
            System.out.println("Put key: " + key + " value: " + value);
            printCache();
        }
    }

    private void printCache() {
        Node current = head.next;
        while(current != tail) {
            System.out.println("key: " + current.key + " value: " + current.value + " frequency: " + current.frequency);
            current = current.next;
        }
    }

    static void test1(){
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1); // cache is {1=1}
        cache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(cache.get(1));    // return 1
        cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(cache.get(2));    // return -1 (not found)
        System.out.println(cache.get(3));    // return 3
        cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(cache.get(1));    // return -1 (not found)
        System.out.println(cache.get(3));    // return 3
        System.out.println(cache.get(4));    // return 4
    }

    /**
     * ["LFUCache","put","put","get","get","get","put","put","get","get","get","get"]
     * [[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]
     */
    static void test2(){
        LFUCache cache = new LFUCache(3);
        cache.put(2, 2);
        cache.put(1, 1);
        cache.get(2);
        cache.get(1);
        cache.get(2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.get(4);
    }

    public static void main(String[] args) {
        test2();
    }
}
