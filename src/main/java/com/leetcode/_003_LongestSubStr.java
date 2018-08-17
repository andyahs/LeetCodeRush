package com.leetcode.www;

import java.util.Arrays;

//����һ���ַ����в��ظ�������ַ���
public class _003_LongestSubStr {

	public static int lengthOfLongestSubStr(String s){
		int[] m = new int [256];
		Arrays.fill(m,-1);
		int res = 0,left = -1;
		for(int i = 0 ;i<s.length();i++){
			left = Math.max(left, m[s.charAt(i)]);
			System.out.println("left:"+left);
			System.out.println("s.charAt(i):"+s.charAt(i));
			m[s.charAt(i)] = i;
			System.out.println("m[s.charAt(i)]:"+m[s.charAt(i)]);
			res = Math.max(res, i - left);
			System.out.println("res:"+res);
			System.out.println("-----------------");
		}
		System.out.println("m[c]:"+m['c']+"mc_int"+(int)('a'));
		return res;
	}
	public static void main(String[] args) {
		int x =0;
		String str1 = "abcabc1adc2";
		x = lengthOfLongestSubStr(str1);
		System.out.println("x:"+x);
	}
}
