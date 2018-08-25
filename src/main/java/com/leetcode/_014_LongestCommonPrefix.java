package com.leetcode;

public class _014_LongestCommonPrefix {
	//最长公共前缀
	public static String longestComPredix(String[] strs){
		if(strs == null ||strs.length ==0 ) return "";
		for(int j = 0;j <strs[0].length(); j++){
			for(int i = 0; i<strs.length -1 ;++i){
				if( j >= strs[i].length() || j >= strs[i+1].length()|| strs[i].charAt(j) !=strs[i+1].charAt(j)){
					return strs[i].substring(0, j);
				}
			}
		}
		return strs[0];
	}
	public static void main(String[] args) {
		String[] strs ={"9871","987214","987fd"}; 
		System.out.println(longestComPredix(strs));
	}
}
