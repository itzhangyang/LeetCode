package com.leetcode.learning.binarytree;

/**
 * Construct a binary tree from the preorder and inorder traversal of the tree.
 * Preorder traversal: root -> left -> right
 * Inorder traversal: left -> root -> right
 *
 */
public class ConstructFromPreorderAndInorder {

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                   int[] inorder, int inStart, int inEnd) {
            // If the start index is greater than the end index, return null
            // This means that there are no nodes in the tree
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            // The first element in the preorder is the root of the tree
            int rootVal = preorder[preStart];
            // Construct the root node
            TreeNode root = new TreeNode(rootVal);
            // Find the index of the root in the inorder array
            int rootInorderIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) {
                    rootInorderIndex = i;
                    break;
                }
            }
            // Calculate the number of nodes in the left subtree
            int leftSize = rootInorderIndex - inStart;
            // Build the left subtree
            root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootInorderIndex - 1);
            // Build the right subtree
            root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, rootInorderIndex + 1, inEnd);
            return root;
        }
    }
}
