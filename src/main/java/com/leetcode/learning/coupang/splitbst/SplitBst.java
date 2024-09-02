package com.leetcode.learning.coupang.splitbst;

/**
 * LeetCode 776. Split BST
 * Input:
 * Given the root of a binary search tree (BST) and an integer target
 * Output : split the tree into two subtrees where
 * - one subtree has nodes that are all smaller or equal to the target value,
 * - the other subtree has all nodes that are greater than the target value.
 * - It is not necessarily the case that the tree contains a node with the value target. (which means the target is either in left or right subtree)
 */
public class SplitBst {

    static class Solution {
        /**
         * Splits the given binary search tree into two subtrees
         * Time complexity: O(h) where h is the height of the tree
         * Space complexity: O(h) where h is the height of the tree
         * Algorithm step by step:
         *
         * @param root root of the binary search tree
         * @param target target value
         * @return array of two subtrees
         */
        public TreeNode[] splitBST(TreeNode root, int target) {
            if (root == null) {
                return new TreeNode[]{null, null};
            }

            TreeNode[] split;
            // if root <= target, means that the target is in the right subtree
//            if (root.val <= target) {
//                // split the right subtree
//                // root, splits[0],splits[1], will split in split[1]
//                split = splitBST(root.right, target);
//
//                root.right = split[0];
//
//                split[0] = root;
//            } else {
//                // split the left subtree
//                split = splitBST(root.left, target);
//                root.left = split[1];
//                split[1] = root;
//            }
//            return split;
            TreeNode [] rightSplits = splitBST(root.right, target);
            TreeNode [] leftSplits = splitBST(root.left, target);
            if(root.val <= target){ // target is in the right subtree
                root.right = rightSplits[0];// merge rightSplits[0] to root.right
                rightSplits[0] = root;
                return rightSplits;
            }else {
                root.left = leftSplits[1];
                leftSplits[1] = root;
                return leftSplits;
            }
        }
    }
}
