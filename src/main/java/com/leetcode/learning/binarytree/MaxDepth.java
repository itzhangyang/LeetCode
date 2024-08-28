package com.leetcode.learning.binarytree;

public class MaxDepth  {

    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // Get the depth of the left subtree
            int left = maxDepth(root.left);
            // Get the depth of the right subtree
            int right = maxDepth(root.right);
            // Return the maximum depth of the left and right subtrees
            return Math.max(left, right) + 1;
        }
    }

}
