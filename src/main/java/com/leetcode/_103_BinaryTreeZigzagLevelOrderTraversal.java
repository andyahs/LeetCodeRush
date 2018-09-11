package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Andiz
 * 2018/9/11 15:10
 * coding For love and Peace
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
//103二叉树锯齿形遍历  [1,2,3,4,null,null,5]   [3,9,20,null,null,15,7]
public class _103_BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> curStack= new Stack<>();

        curStack.push(root);
        List<Integer> curListVal = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(null ==root) return res;
        boolean rightFlag=  true;
        while ( !curStack.isEmpty()) {
            Stack<TreeNode> nextStack= new Stack<>();
            while (!curStack.isEmpty()){
                TreeNode node = curStack.pop();
                curListVal.add(node.val);
                //当前是rightflag，下面就从坐往右
                if (rightFlag) {
                    if (null != node.left) nextStack.push(node.left);
                    if (null != node.right) nextStack.push(node.right);
                }else{
                    if (null != node.right) nextStack.push(node.right);
                    if (null != node.left) nextStack.push(node.left);
                }
            }
            res.add(curListVal);
            curListVal = new ArrayList<>();
            curStack = nextStack;
            rightFlag = rightFlag? false:true;
        }

        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode createBinTree(int[] array) {
        List<TreeNode> nodeList = new LinkedList<TreeNode>();
        // 将一个数组的值依次转换为TreeNode节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            TreeNode root =new TreeNode(array[nodeIndex]);
            nodeList.add(root);
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
        return nodeList.get(0);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,0,0,5};
        TreeNode root= createBinTree(nums);
        List<List<Integer>> reslist = zigzagLevelOrder(root);
    }
}
