package com.leetcode;

import javax.xml.transform.Result;
import java.util.Arrays;

//最长回文字符串
public class _005_LongestPalindromicSubstring {
	
	public static String longestPalindrome(String s){
		if (s.length()<=1) return s;
		String t = "$#";
		char [] sArr = s.toCharArray();
		for(int i = 0; i<sArr.length;++i){
			t += sArr[i];
			t += '#' ;
		}
		char [] tArr = t.toCharArray();
		System.out.println(tArr);
		int [] p= new int [t.length()] ; 
		Arrays.fill(p, 0);
		int id =0,mx=0,resId=0,resMx =0;
		
		for(int i =0;i<t.length();i++){
			p[i] = mx > i ? Math.min(p[2*id -i],mx-i) : 1;
			System.out.println("i"+i+"  "+"p[i]"+p[i]);
			while(i+p[i] <=tArr.length-1 && i-p[i] >=0 &&(tArr[i+p[i]] == tArr[i - p[i]])){
				++p[i];
			}
			if( mx <i+p[i]){
				mx = i+p[i];
				id =i ;
			}
			if(resMx < p[i]){
				resMx = p[i];
				resId = i ;
			}
		}
		System.out.println("resId:"+resId+"  resMx:"+resMx);
		return s.substring((resId-resMx)/2,(resId+resMx)/2-1);
	}
	public static void main(String[] args) {
//		String s = "abatggfs54765789987rty";
		String s = "";
		String lgestPalindicStr = longestPalindrome(s);
		System.out.println("lgestPalindicStr:"+lgestPalindicStr);
	}
	
}
