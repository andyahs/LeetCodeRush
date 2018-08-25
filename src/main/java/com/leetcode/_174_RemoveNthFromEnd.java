package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/26 0:29
 * coding For love and Peace
 */
public class _174_RemoveNthFromEnd {
    //没有指针写地贼蛋疼
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode leftNode = head;
        ListNode rightNode = head;
        if(n ==1){
            if( null != rightNode.next){
                rightNode = rightNode.next;
                while( null !=rightNode.next ){
                    rightNode = rightNode.next;
                    leftNode = leftNode.next;
                }
                leftNode.next =null;
                return head;

            }else{
                return null;
            }
        }
        while( --n > 0 ){
            if(null == rightNode.next){
                head = null;
                return head;
            }
            rightNode = rightNode.next;
        }
        while( null != rightNode.next){
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }
        if(null == leftNode.next ) {
            head = null ;
            return head;
        }
        leftNode.val = leftNode.next.val;
        leftNode.next=  leftNode.next.next;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode secNode = new ListNode(2);
        head.next = secNode;
        ListNode resNode = removeNthFromEnd(head,1);

    }
}
