package com.leetcode;

import java.util.LinkedList;

//�������
public class _002_TwoNumbers {
	public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> list1,LinkedList<Integer> list2){
		LinkedList<Integer> dummy = new LinkedList<Integer>();
		int d1 = 0;
		int d2 = 0;
		int carry =0 ;
		while(list1.iterator().hasNext() && list2.iterator().hasNext()){
			if(!list1.isEmpty())
			d1 = list1.pop();
			if(!list2.isEmpty())			
			d2 = list2.pop();
			int sum = d1+d2+carry;
			carry = sum >= 10?1:0;
			dummy.push( sum % 10 );
		}
		if(carry == 1) dummy.push(1);
		return dummy;
	}
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		for(int i = 0; i<10 ;i++){
			int x = (int) (Math.random()*9);
			list1.push(x);
			System.out.print(x+"  ");
		}
		System.out.println();
		for(int i = 0; i<10 ;i++){
			int x = (int) (Math.random()*9);
			list2.push(x);
			System.out.print(x+"  ");
		}
		System.out.println();
		LinkedList<Integer> dummy =  addTwoNumbers(list1,list2);
		while(dummy.iterator().hasNext()){
			System.out.print(dummy.pop()+"  ");
		}
	}
}
