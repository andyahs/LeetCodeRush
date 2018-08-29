package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/29 15:50
 * coding For love and Peace
 */
public class _098_ValidateBinarySearchTree {
    //直接中序遍历，看查找树是否left<root<right
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean valid(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
