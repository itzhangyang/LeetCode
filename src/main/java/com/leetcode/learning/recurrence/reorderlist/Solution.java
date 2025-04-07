package com.leetcode.learning.recurrence.reorderlist;

public class Solution {
    public void reorderList(ListNode head) {
        // Base condition
        if (head == null || head.next == null) {
            return ;
        }
        if(head.next.next == null){
            return;
        }
        // Recursive condition
        ListNode tail = head;
        ListNode next = head.next;
        ListNode tailPrev = head;
        while(tail.next != null){
            tailPrev = tail;
            tail = tail.next;
        }
        head.next = tail;
        tailPrev.next = null;
        tail.next = tail;
        reorderList(next);
    }
}
