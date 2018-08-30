package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Andiz
 * 2018/8/30 9:47
 * coding For love and Peace
 */
public class _101_SymmetricTree {
    //先用递归 再用迭代
//    public static boolean  isSymmetric(TreeNode root) {
//        if ( null== root ) return true;
//
//        return isSymmetric(root.left,root.right);
//    }
//
//    public static boolean  isSymmetric(TreeNode left,TreeNode right) {
//        if ( null== left && null == right ) return true;
//        if(left == null || right == null) return false;
//        if(left.val != right.val) return false;
//        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
//
//    }
    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        if (null == root ) return true;
        q1.add(root.left);
        q2.add(root.right);
        while (!q1.isEmpty()&& !q2.isEmpty()){
            //每次把上两个压进去的弹出来，校验一下
            TreeNode left = q1.poll(), right = q2.poll();
            if (null !=left || null !=right){
                if (null == left || null ==right)
                    return false;
                if (left.val !=right.val) return false;
            }
            //主要还要考虑null的占位问题，因为如果不占位 ，那么会出现顺边的验证
            if(null !=left){
                q1.add(left.left);
                q1.add(left.right);
            }
            if(null !=right){
                q2.add(right.right);
                q2.add(right.left);
            }

        }
        return true;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
