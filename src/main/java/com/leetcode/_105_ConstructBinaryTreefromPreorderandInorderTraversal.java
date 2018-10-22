package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/12 11:07
 * coding For love and Peace
 * 105从前序与中序遍历序列构造二叉树
 *
 * Preorder:　  　5　　4　　11　　8　　13　　9
 * Inorder:　　 　11　　4　　5　　13　　8　　9
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
        cur.left = buildTree(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1);//找到左子树范围
        cur.right = buildTree(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight);//找到右子树范围
        return cur;
    }

    //LeetCode提供
    //    public TreeNode buildTree(int[] preorder, int[] inorder) {
    //        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
    //            return null;
    //        }
    //        return build(preorder, inorder, 0, 0, inorder.length - 1);
    //    }
    //
    //    public TreeNode build(int[] preOrder, int[] inOrder, int preIndex, int startMidIndex, int endMidIndex) {
    //        if (preIndex > preOrder.length - 1 || startMidIndex > endMidIndex) {
    //            return null;
    //        }
    //        TreeNode node = new TreeNode(preOrder[preIndex]);
    //        int rootMidIndex = endMidIndex;
    //        while (rootMidIndex > startMidIndex) {
    //            if (node.val == inOrder[rootMidIndex]) {
    //                break;
    //            }
    //            rootMidIndex--;
    //        }
    //        if (rootMidIndex > startMidIndex) {
    //            node.left = build(preOrder, inOrder, preIndex + 1, startMidIndex, rootMidIndex - 1);
    //        }
    //        if (rootMidIndex < endMidIndex) {
    //            node.right = build(preOrder, inOrder, preIndex + (rootMidIndex - startMidIndex) + 1,
    //                    rootMidIndex + 1, endMidIndex);
    //        }
    //        return node;
    //    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
