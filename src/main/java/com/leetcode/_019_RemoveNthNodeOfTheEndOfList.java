package com.leetcode;

import java.util.LinkedList;

//���MyList��
public class _019_RemoveNthNodeOfTheEndOfList {

	public static void main(String[] args) {
		MyList<Integer> aList = new MyList<Integer>();
		aList.add(1);aList.add(2);aList.add(3);
		aList.add(4);aList.add(5);aList.add(6);
		aList.add(7);aList.add(8);aList.add(9);
		aList.print();
		System.out.println();
		aList.RemNthNodeFromEnd(aList, 12);
		aList.print();
	}
	
}
