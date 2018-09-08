package com.leetcode;

import java.util.LinkedList;

//两数相加
/*
 *  给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
	你可以假设除了数字 0 之外，这两个数字都不会以零开头。
	示例：
	输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
	输出：7 -> 0 -> 8
	原因：342 + 465 = 807
 *
 */
public class _002_TwoNumbers {
	//看了最速算法。。原理一样执行速度还没我的快~其实可以考虑更多边际条件
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
		ListNode head =new ListNode((l1.val+l2.val)%10);
		ListNode curNode = head;
		int carry =(l1.val+l2.val) >=10?1:0 ;
		while(null != l1.next || null != l2.next){
			int v1 = 0,v2 = 0;
			if( null!= l1.next) {
				l1 = l1.next;
				v1 = l1.val;
			}
			if( null != l2.next) {
				l2 = l2.next;
				v2 = l2.val;
			}
			int sum = v1+v2+carry;
			carry = sum >= 10?1:0;
			ListNode newNode = new ListNode(sum);
			curNode.next = newNode;
			curNode = newNode;
		}
		if(carry == 1) curNode.next = new ListNode(1);
		return head;
	}


	private static class ListNode {
		int val;
		ListNode next;
 		ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
//		for(int i = 0; i<10 ;i++){
//			int x = (int) (Math.random()*9);
//			l1.push(x);
//			System.out.print(x+"  ");
//		}
//		System.out.println();
//		for(int i = 0; i<10 ;i++){
//			int x = (int) (Math.random()*9);
//			l2.push(x);
//			System.out.print(x+"  ");
//		}
//		System.out.println();
//		LinkedList<Integer> dummy =  addTwoNumbers(l1,l2);
//		while(dummy.iterator().hasNext()){
//			System.out.print(dummy.pop()+"  ");
//		}
	}

}
