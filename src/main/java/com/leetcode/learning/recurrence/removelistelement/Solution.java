package com.leetcode.learning.recurrence.removelistelement;


public class Solution {
    public ListNode removeListElement(ListNode head, int val) {
        // Base condition
        if (head == null) {
            return null;
        }
        if(head.val == val) {
            return removeListElement(head.next, val);
        }
        head.next = removeListElement(head.next, val);
        return head;
    }
}
