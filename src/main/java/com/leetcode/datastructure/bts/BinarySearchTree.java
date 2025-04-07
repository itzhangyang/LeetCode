package com.leetcode.datastructure.bts;

import java.util.Objects;

public class BinarySearchTree {
    private BinaryNode root;
    public BinarySearchTree (){
        this(null);
    }
    public BinarySearchTree(BinaryNode root){
        this.root = root;
    }
    private Integer findMin(BinaryNode root){
        if (root == null){
            return null;
        }
        if (root.left == null) {
            return root.data;
        }
        return findMin(root.left);
    }

    private Integer findMax(BinaryNode root) {
        if(root == null){
            return null;
        }
        if(root.right==null){
            return root.data;
        }
        return findMax(root.right);
    }
    /**
     * Check whether a BTS contains a value
     * @param value value
     * @param root root of the BST
     * @return Boolean, whether contains
     */
    private Boolean contains(Integer value, BinaryNode root) {
        if (root == null) {
            return Boolean.FALSE;
        }

        if (root.data < value) {
            return contains(value, root.right);
        }
        if (root.data > value) {
            return contains(value, root.left);
        }
        return Boolean.TRUE;
    }

    /**
     * Insert a node to BTS
     * @param value the value to be inserted
     * @param root the as-is root of the BST
     * @return The new root of the BST
     * To insert a new node
     */
    private BinaryNode insert(Integer value,BinaryNode root){
        if (root == null) {
            return new BinaryNode(value,null,null);
        }
        if (root.data < value) {
            root.left = insert(value,root.left);
        }
        if (root.data > value) {
            root.right = insert(value,root.right);
        }
        return root;
    }

    /**
     *
     * @param value The node to be removed
     * @param root The as-is root of the BST
     * @return The new root of the BST
     */
    private BinaryNode remove (Integer value, BinaryNode root){
        //1. If root is null, return nul
        if (root == null) {
            return null;
        }
        //2.If root value > value, do the operation on the left subtree
        if (root.data > value) {
            root.left = remove(value,root.left);
        }
        //3.If the root value < value, do the operation on the right subtree
        if(root.data < value) {
            root.right = remove(value,root.right);
        }
        //4. If root value = value
        //4.1 If left is null, return right
        if (root.left == null) {
            return root.right;
        }
        //4.2 If right is null, return left
        if (root.right == null) {
            return root.left;
        }
        //4.3 If both left and right are not null
        // Set the max node on the left node or the min node on right as the new root
        root.data = findMin(root.right);
        root.right = remove(root.data,root.right);
        return root;
    }
}
