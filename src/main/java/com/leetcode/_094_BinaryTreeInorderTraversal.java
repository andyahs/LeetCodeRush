package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Andiz
 * 2018/9/10 14:24
 * coding For love and Peace
 */
//中序遍历二叉树
//扩展阅读 三种遍历各自的三种方法http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
//可以看一下Morris Traversal以及他用到的螺旋二叉树
public class _094_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        //主要思路是用stack来做
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while ( true){
            if (null !=root){
                stack.push(root);
                root = root.left;
            }else {
                if(stack.isEmpty()){
                    return list;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }

        }

//        List<Integer> list = new ArrayList<>();
//        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
//
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.addFirst(root);
//                root = root.left;
//            }
//            root = stack.removeFirst();
//            list.add(root.val);
//            root = root.right;
//        }

//        return list;
    }

     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
}
