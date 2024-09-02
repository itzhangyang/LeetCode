package com.leetcode.learning.coupang.glassdoor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorderTraversal(root, result);
            return result;
        }

        private void inorderTraversal(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }

        private List<TreeNode> inorderTraversalIterative(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<TreeNode> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                // Put the most left node of each level to the stack
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                // Pop the top node from the stack, which is the left-bottom node in the tree
                // add it to the result list
                root = stack.pop();
                result.add(root);
                root = root.right;

            }
            return result;
        }
    }
}
