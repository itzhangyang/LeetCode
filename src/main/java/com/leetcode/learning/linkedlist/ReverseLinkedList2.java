package com.leetcode.learning.linkedlist;

public class ReverseLinkedList2   {
    static class Solution {
        /**
         * Reverse a linked list from position m to n. Do it in one-pass.
         * Note: 1 ≤ m ≤ n ≤ length of list.
         * Input: 1->2->3->4->5->NULL, m = 2, n = 4
         * Output: 1->4->3->2->5->NULL
         * Solution:
         * 1. Find the node before the start node
         * 2. Reverse the nodes between m and n
         * 3. Return the head of the reversed list
         * @param head The head of the linked list
         * @param left The start position
         * @param right The end position
         * @return The head of the reversed linked list
         */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null) {
                return null;
            }
            // Create a dummy node
            // Pointer0 to point to the dummy node
            ListNode dummy = new ListNode(0);
            // Connect the dummy node to the head
            dummy.next = head;
            // Create a pointer to node before the start node
            // Pointer1 to point to the node before the start node
            ListNode pre = dummy;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            // The start node
            ListNode start = pre.next;
            // Pointer2 to point to the start node
            ListNode then = start.next;
            for (int i = 0; i < right - left; i++) {
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = start.next;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution.reverseBetween(head, 2, 4);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
