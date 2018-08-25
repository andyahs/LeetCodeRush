package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/25 22:52
 * coding For love and Peace
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _237_DeleteNode {
    //定义了单向链表并删除一个节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}
