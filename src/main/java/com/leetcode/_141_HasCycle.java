package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/28 22:45
 * coding For love and Peace
 */
public class _141_HasCycle {

    public static boolean hasCycle(ListNode head){
        if (null == head || null == head.next) return false;
        ListNode left = head;
        ListNode right = head;
        int i = 0;
        while (null !=left.next && null !=right.next){
            if(i++ > 10000) return false;
            if(null == right.next.next) return false;
            left = left.next;
            right = right.next.next;
            if (left ==right){
                return true;
            }
        }
        return false;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
}
