package com.leetcode.learning.dc.majorityelement;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> elementCountMap = new HashMap<>();
        for (int num : nums) {
            if (elementCountMap.containsKey(num)) {
                elementCountMap.put(num, elementCountMap.get(num) + 1);
            } else {
                elementCountMap.put(num, 1);
            }
        }
        return elementCountMap.entrySet().stream().filter(element -> element.getValue() > nums.length / 2).findFirst().get().getKey();
    }
}
