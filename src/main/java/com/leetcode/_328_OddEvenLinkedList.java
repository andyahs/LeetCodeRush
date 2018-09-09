package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/9 14:10
 * coding For love and Peace
 */
//奇偶链表
public class _328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (null ==head ||null ==head.next) return head;
        ListNode preNode = head;
        ListNode curNode = head.next;
        while (null !=curNode && null!=curNode.next){
            ListNode tmp = preNode.next;
            preNode.next = curNode.next;
            curNode.next = curNode.next.next;
            preNode.next.next  =tmp;
            curNode = curNode.next;
            preNode = preNode.next;

        }


        return head;
        //看了一下  还有用双链表来存放的 不过效率不高
        //        if(head == null)
        //            return null;
        //        ListNode node1 = new ListNode(0);   //放奇数位
        //        ListNode node2 = new ListNode(0);   //放偶数位
        //        ListNode p1 = node1;
        //        ListNode p2 = node2;
        //        int index = 1;
        //        while(head != null){
        //            if(index%2 == 1){
        //                p1.next = head;
        //                p1 = p1.next;
        //            }else{
        //                p2.next = head;
        //                p2 = p2.next;
        //            }
        //            head = head.next;
        //            index++;
        //        }
        //        p2.next = null;
        //        p1.next = node2.next;
        //        return node1.next;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
