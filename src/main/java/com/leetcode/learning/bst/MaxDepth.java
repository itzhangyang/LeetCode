package com.leetcode.learning.bst;

import com.google.gson.Gson;
import com.leetcode.learning.model.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class MaxDepth {
    static class Solution {
        /**
         * Given a binary tree, find its maximum depth.
         * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
         * Note: A leaf is a node with no children.
         * @param root Root Node
         * @return Max Depth
         */
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // Create a queue to store the nodes
            Queue<TreeNode> queue = new LinkedList<>();
            // Put the root node in the queue
            System.out.println("Put The Root in to the queue: " + root.value);
            queue.offer(root);
            int depth = 0;
            // Iterate through the queue
            while (!queue.isEmpty()) {
                List<Integer> values = queue.stream().map(node -> node.value).collect(Collectors.toList());
                System.out.println("The nodes in the queue: "+ new Gson().toJson(values));
                // For each node in the queue
                int size = queue.size();
                // Take all the nodes from the queue and add their children to the queue
                for (int i = 0; i < size; i++) {
                    // Poll a node from the queue
                    TreeNode node = queue.poll();
                    System.out.println("Poll a node from the queue: " + node.value);
                    // If the node has a left or right child, add it to the queue
                    if (node.left != null) {
                        System.out.println("The node has a left child, put it in the queue: " + node.left.value);
                        queue.offer(node.left);
                    }
                    // If the node has a right child, add it to the queue
                    if (node.right != null) {
                        System.out.println("The node has a right child, put it in the queue: " + node.right.value);
                        queue.offer(node.right);
                    }
                }
                // Increment the depth
                depth++;
            }
            return depth;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));
    }
}
