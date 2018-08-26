package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andiz
 * 2018/8/26 16:49
 * coding For love and Peace
 */
public class _206_ReverseLinkedList {

    public static ListNode  reverseList(ListNode head){
        //第一种方法 暴力遍历，然后反向循环
//        if(null ==head|| null==head.next) return head;
//        ListNode curNode = head;
//        List<Integer> valList = new ArrayList<Integer>();
//        while (null != curNode.next){
//            valList.add(curNode.val);
//            curNode = curNode.next;
//        }
//        valList.add(curNode.val);
//        curNode = head;
//        for (int i = 0; i < valList.size(); i++) {
//            curNode.val = valList.get(valList.size()-i-1);
//            curNode = curNode.next;
//        }
//        return head;

        //很显然 应该用正统的交换方式来做，所以二号方法迭代如下
        if ( null ==head.next) return head;
        ListNode curNode = head;
        ListNode pre = null;
        ListNode next ;
        while (null !=curNode.next){
            next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }
        curNode.next =pre;
        return curNode;


        //之后是三号方法递归
//        if (null==head||null ==head.next) return head;
//        ListNode next= head.next;
//        head.next = null;
//        ListNode re = reverseList(next);
//        next.next = head;
//        return re;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode curNode = head;
        for (int i=4 ; i<12; i++){
            ListNode newNode = new ListNode(i);
            curNode.next = newNode;
            curNode = newNode;
        }
        ListNode result = reverseList(head);
        while ( null !=result.next){
            System.out.print( "--"+result.val+" ");
            result = result.next;
        }
        System.out.print("--"+result.val+"  ");
    }
}
