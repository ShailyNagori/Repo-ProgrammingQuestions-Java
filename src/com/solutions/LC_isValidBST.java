package com.solutions;
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
 */

import com.commons.TreeNode;


import java.util.Stack;

public class LC_isValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val >= root.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        LC_isValidBST obj = new LC_isValidBST();
        TreeNode root = new TreeNode(2);

    }
}
