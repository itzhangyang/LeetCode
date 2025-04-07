package com.leetcode.learning.recurrence.addtwonumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    /**
     * Recursively add two numbers represented by linked lists
     * Base condition:
     * 1. If both lists are empty and there is no carry, return null
     * Recursive case:
     * 1. Calculate the sum of the current nodes of the two lists and the carry
     * 2. Create a new node with the sum as the value and recursively add the next nodes of the two lists and the carry
     * @param l1
     * @param l2
     * @param carry carry from the previous addition
     * @return
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        // Base cases
        // Base case 1: If both lists are empty and there is no carry, return null
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = 0;
        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }
        sum += carry;
        ListNode head = new ListNode(sum % 10);
        head.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum / 10);
        return head;
    }
}
