package com.leetcode;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Andiz
 * 2018/8/30 14:14
 * coding For love and Peace
 */
//输入[1,2,3,4,null,null,5]
//输出[[1],[2,3],[4,5]]
    //in [1,2,null,3,null,4,null,5] out [[1],[2],[3],[4],[5]]
public class _102_BinaryTreeLevelOrderTraversal {
    //我用的全是while 和isEmpty来检测，所以1ms，100% 另外一种100%的是递归
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> all = new LinkedList<>();
//        List<Integer> level = new LinkedList<>();
//        if( null ==root){
//            return all;
//        }
//        level.add(root.val);
//        all.add(level);
//        if (null ==root.left&& null ==root.right)   return  all;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        Queue<TreeNode> queNxt = new LinkedList<>();
//        List<Integer> curLv = new LinkedList<>();
//        while (!queue.isEmpty()){
//            TreeNode curNode = queue.poll();
//            if (null !=curNode.left){
//                curLv.add(curNode.left.val);
//                queNxt.add(curNode.left);
//            }
//            if (null !=curNode.right){
//                curLv.add(curNode.right.val);
//                queNxt.add(curNode.right);
//            }
//            if( queue.isEmpty() ){
//                if(!curLv.isEmpty())    all.add(curLv);
//                if (!queNxt.isEmpty()){
//                    queue = queNxt;
//                    queNxt = new LinkedList<>();
//                    curLv = new LinkedList<>();
//                }
//            }
//        }
//
//        return all;
//    }

    //  以下是大佬们的迭代法，主要比以前多了level参数,根据level带加入遍历到node值
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        set(root, 0, result);
        return result;
    }

    public void set(TreeNode treeNode, int level, List<List<Integer>> result) {
        if(treeNode==null){
            return;
        }
        if(level==result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(treeNode.val);
        set(treeNode.left,level+1,result);
        set(treeNode.right,level+1,result);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
