package com.leetcode;

import java.util.Stack;

/**
 * Created by Andiz
 * 2018/8/28 23:25
 * coding For love and Peace
 */
public class _104_MaximumDepthofBinaryTree {

    //一种是递归法 非常优雅
    public int maxDepth(TreeNode root) {
//        if (root == null)   return 0;
//        int left_depth = maxDepth(root.left);
//        int right_depth = maxDepth(root.right);
//        return Math.max(left_depth, right_depth) + 1;
//    }

    //第二种用栈或者队列都行
    if(root ==null)return 0;
    Stack<TreeNode> nodestack = new Stack<TreeNode>();
    Stack<Integer> depthstack = new Stack<Integer>();
    int maxdepth = 1;
        nodestack.push(root);
        depthstack.push(maxdepth);
        while(!nodestack.isEmpty())

    {
        TreeNode node = nodestack.pop();
        int d = depthstack.pop();
        if (d > maxdepth) maxdepth = d;
        if (node.left != null) {
            nodestack.push(node.left);
            depthstack.push(d + 1);
        }
        if (node.right != null) {
            nodestack.push(node.right);
            depthstack.push(d + 1);
        }
    }
        return maxdepth;
}

     private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


}
