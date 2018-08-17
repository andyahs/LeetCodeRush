package com.leetcode.www;

//����
public class _007_ReverseInteger {
	public static int reverseInteger(int x){
		int res = 0;
		int flag = 1;
		if(x <0) {
			flag = -1;
			x *= flag;
		}
		while(x >0){
			res = res*10+x%10;
			x=(x-x%10)/10;
		}
		return res*flag;
	}
	
	public static void main(String[] args) {
		int x = -987654321;
		System.out.println("res:"+reverseInteger(x));
	}
}
