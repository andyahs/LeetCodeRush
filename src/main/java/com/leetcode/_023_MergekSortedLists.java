package com.leetcode;

public class _023_MergekSortedLists<AnyType> {
//合并两个链表，直接用迭代法实现
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {

	}
}
