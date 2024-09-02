package com.leetcode.learning.coupang.rangemodule;

import java.util.ArrayList;
import java.util.List;

/**
 * 715. Range Module
 * A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.
 * Design a data structure to track the ranges represented as half-open intervals and query about them.
 * A half-open interval [left, right) denotes all the real numbers x where left <= x < right.
 * Implement the RangeModule class:
 * RangeModule() Initializes the object of the data structure.
 * void addRange(int left, int right) Adds the half-open interval [left, right) to the module.
 * boolean queryRange(int left, int right) Returns true if every real number in the interval [left, right) is currently in the module, and false otherwise.
 * void removeRange(int left, int right) Removes the half-open interval [left, right) from the module.
 * Example 1:
 * Input
 * ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
 * [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
 * Output
 * [null, null, null, true, false, true]
 * Explanation
 * RangeModule rangeModule = new RangeModule();
 * rangeModule.addRange(10, 20);
 * rangeModule.removeRange(14, 16);
 * rangeModule.queryRange(10, 14); // return False,(10, 14) is not in the module
 * rangeModule.queryRange(13, 15); // return True,(13, 15) is in the module
 * rangeModule.queryRange(16, 17); // return True,(16, 17) is in the module
 *
 */
public class RangeModule {
    List<Range> ranges ;

    public RangeModule() {
        ranges = new ArrayList<>();
    }

    public void addRange(int left, int right) {
        addRange(new Range(left, right));
    }

    private void addRange(Range range) {
        if (ranges.isEmpty()) {
            ranges.add(range);
            return;
        }
        int i = 0;
        // Find out the range to be merged or inserted(before)
        // Find an existing range that: range.right >= range.left
        while (i < ranges.size() && ranges.get(i).right < range.left) {
            i++;
        }
        // If the range to be inserted is not found
        // Add the range to the end of the list
        if (i == ranges.size()) {
            ranges.add(range);
            return;
        }
        // If the range to be inserted is found
        // Insert the range to the correct position
        if (ranges.get(i).left > range.right) {
            // The add method in the list will insert the element at the specified position and shift the elements in the list to the right
            ranges.add(i, range);
            return;
        }
        // If the range to be merged is found
        Range rangeToMerge = ranges.get(i);
        rangeToMerge.left = Math.min(rangeToMerge.left, range.left);
        rangeToMerge.right = Math.max(rangeToMerge.right, range.right);

        // Find out the range next to the merged range (Next)
        // If the
        int nextIndex = i+1;
        if (nextIndex < ranges.size()) {
            Range next = ranges.get(nextIndex);
            while (next != null && next.left <= rangeToMerge.right) {
                rangeToMerge.right = Math.max(rangeToMerge.right, next.right);
                ranges.remove(nextIndex);
                next = nextIndex < ranges.size() ? ranges.get(nextIndex) : null;
            }
        }
    }

    public boolean queryRange(int left, int right) {
        for (Range range : ranges) {
            if (range.left <= left && range.right >= right) {
                return true;
            }
        }
        return false;
    }

    public void removeRange(int left, int right) {
        int i=0;
        while (i < ranges.size() && ranges.get(i).right <= left) {
            i++;
        }
        Range range = ranges.get(i);
        // If the range to be removed is inside the found range
        if (range.left < left) {
            Range firstRange = new Range(range.left, left);
            Range secondRange = new Range(right, range.right);
            ranges.remove(i);
            ranges.add(i, secondRange);
            ranges.add(i, firstRange);
            return;
        }
        // If the range to be removed is crossing the found ranges
        if (range.left > left) {

        }

    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        System.out.println(rangeModule.queryRange(10, 14)); // return False,(10, 14) is not in the module
        System.out.println(rangeModule.queryRange(13, 15)); // return True,(13, 15) is in the module
        System.out.println(rangeModule.queryRange(16, 17)); // return True,(16, 17) is in the module
    }
}
