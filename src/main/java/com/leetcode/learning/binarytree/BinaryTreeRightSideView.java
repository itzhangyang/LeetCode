package com.leetcode.learning.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView   {

    static class Solution {

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            // Add the root node to the result
            result.add(root.val);
            // Get the rightest node of each level
            if (root.right != null) {
                result.addAll(rightSideView(root.right));
            } else {
                result.addAll(rightSideView(root.left));
            }
            return result;
        }
    }
}
