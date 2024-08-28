package com.leetcode.learning.bst;

import com.leetcode.learning.model.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/same-tree/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */

public class IsSameTree {
    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null && q==null){
                return true;
            }
            if(p==null || q==null){
                return false;
            }
            if(p.value!=q.value){
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}
