package com.leetcode.learning.coupang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 Implement the RandomizedSet class:

 RandomizedSet() Initializes the RandomizedSet object.
 bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class HighPerformanceRandomizedSet {
    static class RandomizedSet {
        Map<Integer, Integer> map ;
        List<Integer> arr;
        public RandomizedSet() {
            arr = new ArrayList<>();
            arr.add(0, 1);
            map = new HashMap<>();
            map.put(1, 0);

        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            arr.add(map.size(),val);
            map.put(val, map.size());
            return false;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int index = map.get(val);
                map.remove(val);
                arr.remove(index);
                return true;
            }
            return false;
        }

        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }

    /**
     * ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
     * [[],[1],[2],[2],[],[1],[2],[]]
     * @param args
     */
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println("insert 1:" + obj.insert(1));
        System.out.println("remove 2:" + obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}
