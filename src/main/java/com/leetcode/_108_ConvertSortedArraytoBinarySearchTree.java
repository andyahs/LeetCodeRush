package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/31 9:35
 * coding For love and Peace
 */
//将有序数组转换为二叉搜索树
public class _108_ConvertSortedArraytoBinarySearchTree {
    // 直接暴力二分查找 稳如狗
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return sortedArrayToBST(nums, 0 , nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int left, int right){
        if (left > right ) return null;
        int mid = ( left + right )/2;
        TreeNode curNode = new TreeNode(nums[mid]);
        curNode.left = sortedArrayToBST(nums,left, mid -1);
        curNode.right = sortedArrayToBST(nums,mid +1,right);
        return curNode;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int [] sortArr = {1,2,3,4,5};
        TreeNode root = sortedArrayToBST(sortArr);
        System.out.println(root.val);
    }
}
