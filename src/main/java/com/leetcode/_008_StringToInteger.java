package com.leetcode;
//string to int  consider about some situation
public class _008_StringToInteger {

		public static int toMyAtoi(String str){
			//可以先转成char[]来做
			//str = str.trim();先切掉空白
			if(str.isEmpty()) return 0;
			int sign = 1,base = 0, i=0, n=str.length();
			while(i<n&& str.charAt(i)== ' ') ++i;
			if (i>=n) return base;
			if(str.charAt(i) =='+' || str.charAt(i) =='-'){
				sign = (str.charAt(i++) =='+')? 1 : -1;
			}
			while(i < n ){
				if (str.charAt(i) <'0'
						|| str.charAt(i) > '9') break;
				if(base > Integer.MAX_VALUE /10 ||(base == Integer.MAX_VALUE /10)
						&& str.charAt(i) - '0' >7){
					return (sign ==1 )?Integer.MAX_VALUE :Integer.MIN_VALUE;
				}
				base = 10*base + (str.charAt(i++) - '0' );
			}
			return base *sign;
		}
		public static void main(String[] args) {
			String str = " ";
			System.out.println("xRE:"+toMyAtoi(str));
				
		}
}
