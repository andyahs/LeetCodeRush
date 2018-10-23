package com.leetcode;

import java.util.Stack;

/**
 * Created by Andiz
 * 2018/9/13 10:06
 * coding For love and Peace
 * 230Kth Smallest Element in a BST 二叉搜索树中的第K小的元素
 * //又称为二叉排序树
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 *
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 */
public class _230_KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        //一 非迭代方法 //[5,3,6,2,4,null,null,1]3   [1,null,2] 2  [3,1,4,null,2]
        int count =0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (null !=curNode ||!stack.isEmpty()){
            while ( null !=curNode &&null !=curNode.left){
                stack.push(curNode);
                curNode = null !=curNode.left? curNode.left: null;
            }
            if(!stack.isEmpty()){
                curNode = stack.peek();
                stack.pop();
            }
            count++;
            //System.out.println("cont="+count+" val "+curNode.val);
            if (count == k) return curNode.val;
            if (null != curNode.right){
                stack.push(curNode.right);
                curNode = curNode.right;
            }else{
                curNode = null;
            }

        }
        return 0;
    }


    //迭代方法
    //    static int count = 0;
    //    public int kthSmallest(TreeNode root, int k) {
    //        count = k;
    //        return helper(root);
    //    }
    //
    //    protected int helper(TreeNode root) {
    //        if (root == null) {
    //            return Integer.MIN_VALUE;
    //        }
    //        int i = helper(root.left);
    //        if (i != Integer.MIN_VALUE) return i;
    //        count --;
    //        if (count == 0) return root.val;
    //        return helper(root.right);
    //    }


    //leetCode提供
    //     public static int kthSmallest(TreeNode root, int k) {
    //        int num = count(root.left);
    //        if (num == k - 1){
    //            return root.val;
    //        } else if (num > k - 1) {
    //            return kthSmallest(root.left, k);
    //        } else {
    //            return kthSmallest(root.right, k - num - 1);
    //        }
    //    }
    //
    //    private static int count(TreeNode node){
    //        if (node == null) return 0;
    //        return 1 + count(node.left) + count(node.right);
    //    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
