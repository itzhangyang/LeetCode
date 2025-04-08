package com.leetcode.learning.recurrence.mergesortedlinedlist;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // base case
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // sub problems
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode result = solution.mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
