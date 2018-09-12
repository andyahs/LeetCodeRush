package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/12 14:30
 * coding For love and Peace
 *
 * 每个节点的右向指针
 * 给定完美二叉树，
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 *
 * 调用你的函数后，该完美二叉树变为：
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
public class _116_PopulatingNextRightPointersinEachNode {

    public void connect(TreeLinkNode root) {

        TreeLinkNode start = root;
        TreeLinkNode cur = start;

        while (null != start){
            cur = start;
            while (null !=cur){
                if (null != cur.left ) cur.left.next =cur.right;
                if (null != cur.next && null!= cur.right) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            start =start.left;
        }
        //最快的还是迭代法
        //        if(root == null) return;
        //        if(root.left != null){
        //            root.left.next = root.right;
        //            if(root.next != null){
        //                root.right.next = root.next.left;
        //            }
        //        }
        //        connect(root.left);
        //        connect(root.right);
    }

    public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
    }
}
