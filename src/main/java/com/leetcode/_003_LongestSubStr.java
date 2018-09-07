package com.leetcode;

import java.util.Arrays;

//无重复字符的最长子串的长度
public class _003_LongestSubStr {

	public static int lengthOfLongestSubStr(String s){
		//这个奇葩方法就是用字符转码做下标，然后存储最后一个出现的位置
		//i-left得出目前字符串长度
		int[] m = new int [256];
		Arrays.fill(m,-1);
		int res = 0,left = -1;
		for(int i = 0 ;i<s.length();i++){
			left = Math.max(left, m[s.charAt(i)]);
//			System.out.println("left:"+left);
//			System.out.println("s.charAt(i):"+s.charAt(i));
			m[s.charAt(i)] = i;
//			System.out.println("m[s.charAt(i)]:"+m[s.charAt(i)]);
			res = Math.max(res, i - left);
//			System.out.println("res:"+res);
//			System.out.println("-----------------");
		}

		return res;
	}
	public static void main(String[] args) {
		int x =0;
		String str1 = "abcabc1adc2";
		x = lengthOfLongestSubStr(str1);
		System.out.println("x:"+x);
	}
}
