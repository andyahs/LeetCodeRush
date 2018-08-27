package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andiz
 * 2018/8/27 18:27
 * coding For love and Peace
 */
public class _234_IsPalindrome {

    public static boolean isPalindrome(ListNode head){
        //边际判断
        if(null ==head ||null ==head.next) return true;
        ListNode curNode = head;
        List<Integer> valList = new ArrayList<Integer>();
        while (null !=curNode.next){
            valList.add(curNode.val);
            curNode = curNode.next;
        }
        valList.add(curNode.val);
        curNode = head;
        for (int i =0; i<valList.size()/2; i++){
            if (curNode.val != valList.get(valList.size()-1-i)) return false;
            curNode = curNode.next;
        }

        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        ListNode curNode = head;
        for (int i=7 ; i<10; i++){
            ListNode newNode = new ListNode(i);
            curNode.next = newNode;
            curNode = newNode;
        }
        for (int i=8 ; i>5; i--){
            ListNode newNode = new ListNode(i);
            curNode.next = newNode;
            curNode = newNode;
        }
        System.out.println(isPalindrome(head));
    }
}
