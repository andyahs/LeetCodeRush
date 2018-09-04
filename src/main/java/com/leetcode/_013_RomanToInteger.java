package com.leetcode;

import java.util.HashMap;

//罗马数字转int
public class _013_RomanToInteger {
	
	public static int romanToInt(String s){
		char[] str = s.toCharArray();
		int res =0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		for(int i = 0;i <str.length; ++i){
			if(i == 0 || map.get(str[i]) <= map.get(str[i-1])){
				res += map.get(str[i]);
			}else{
				res += map.get(str[i]) - map.get(str[i-1])*2;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String s = "MMMCMLXXXVII";
		System.out.println(romanToInt(s));
	}
}
