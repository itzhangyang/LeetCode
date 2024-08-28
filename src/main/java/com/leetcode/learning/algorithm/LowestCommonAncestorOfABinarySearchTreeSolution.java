package com.leetcode.learning.algorithm;

import com.leetcode.learning.model.TreeNode;

public class LowestCommonAncestorOfABinarySearchTreeSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.value < root.value && q.value < root.value) {
                root = root.left;
            } else if (p.value > root.value && q.value > root.value) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    // Test case
    public static void main(String[] args){
        TreeNode root= new TreeNode(6);
        TreeNode node1= new TreeNode(2);
        TreeNode node2= new TreeNode(8);
        TreeNode node3= new TreeNode(0);
        TreeNode node4= new TreeNode(4);
        TreeNode node5= new TreeNode(7);
        TreeNode node6= new TreeNode(9);
        TreeNode node7= new TreeNode(3);
        TreeNode node8= new TreeNode(5);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node4.left=node7;
        node4.right=node8;
        printTree(root, "");
        LowestCommonAncestorOfABinarySearchTreeSolution solution= new LowestCommonAncestorOfABinarySearchTreeSolution();
        TreeNode result= solution.lowestCommonAncestor(root, node1, node2);
        System.out.println(result.value);
    }

    static void printTree(TreeNode node, String prefix)
    {
        if(node == null) return;

        System.out.println(prefix + " + " + node.value);
        printTree(node.left , prefix + " ");
        printTree(node.right , prefix + " ");
    }
}
