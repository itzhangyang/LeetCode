package com.leetcode.learning.recurrence.swaplinedlistnodes;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // sub problems
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode result = solution.swapPairs(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
