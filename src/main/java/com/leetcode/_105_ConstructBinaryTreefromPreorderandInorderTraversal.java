package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/12 11:07
 * coding For love and Peace
 * 从前序与中序遍历序列构造二叉树
 *
 */
public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode  buildTree(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) return null;
        int i = 0;
        for (i = iLeft; i <= iRight; ++i) {
            if (preorder[pLeft] == inorder[i]) break;
        }
        TreeNode cur = new TreeNode(preorder[pLeft]);
        cur.left = buildTree(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1);
        cur.right = buildTree(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight);
        return cur;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
