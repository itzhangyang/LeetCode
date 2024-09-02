package com.leetcode.learning.coupang.glassdoor;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Leet code 662. Maximum Width of Binary Tree
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels.
 * The binary tree has the same structure as a full binary tree, but some nodes are null.
 * The width of one level is defined as the length between the end-nodes (the left most and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 *
 */
public class BinaryTreeWidth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    static class Pair {
        TreeNode node;
        // The index of the node in the level, which the theoretical index
        // For left child of the current node, the index will be 2n
        // For the right child of the current node, the index will be 2n+1
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    static class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //
            Deque<Pair> queue = new LinkedList<>(); // <node, index>
            queue.add(new Pair(root, 0));//
            int max = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                int start = queue.peekFirst().index;
                int end = queue.peekLast().index;
                max = Math.max(max, end - start + 1);
                // Add the left and right children of the nodes in the queue
                for (int i = 0; i < size; i++) {
                    Pair pair = queue.poll();
                    if (pair.node.left != null) {
                        // The index of the left child is 2 * the index of the parent
                        queue.add(new Pair(pair.node.left, 2 * pair.index));
                    }
                    if (pair.node.right != null) {
                        // The index of the right child is 2 * the index of the parent + 1
                        queue.add(new Pair(pair.node.right, 2 * pair.index + 1));
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(new Solution().widthOfBinaryTree(root));
    }
}
