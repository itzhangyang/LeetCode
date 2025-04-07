package com.leetcode.learning.recurrence.maxbinarytreedepth;

public class Solution {
    public int maxDepth(Node root) {
        // base case
        if (root == null) {
            return 0;
        }
        // sub problems
        // 1. max depth of the left subtree
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // 2. max depth of the right subtree
        // recursive case
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));
    }
}
