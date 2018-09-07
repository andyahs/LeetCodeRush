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
		//以下是一个算法
		//    public String longestPalindrome(String s) {
        //       if(s.length()<=1) return  s;
        //        char[] characters = s.toCharArray();
        //        //用于存放str中最长回文子串所对应的下标
        //        int[] range = {0,1};
        //        for(int i = 0;i<characters.length;i++){
        //            i = helper(i,characters,range);
        //        }
        //        return s.substring(range[0],range[1]);
        //    }
        //
        //    private int helper(int index,char[] c,int[] range) {
        //        int low = index;
        //        int high = index;
        //        //如果遇到相同字符，则high进位，如abba ，这样偶回文子串也可以当做奇回文处理了
        //        while(high<c.length-1 && c[high]==c[high+1]){
        //            high++;
        //        }
        //        int cursor = high;
        //
        //        while(high+1<c.length&&low-1>=0&&c[low-1]==c[high+1]){
        //            low--;
        //            high++;
        //        }
        //        if(high-low+1>range[1]-range[0]){
        //            range[0] = low;
        //            range[1] = high + 1;
        //        }
        //        return cursor;
        //    }
	}
	public static void main(String[] args) {
//		String s = "abatggfs54765789987rty";
		String s = "";
		String lgestPalindicStr = longestPalindrome(s);
		System.out.println("lgestPalindicStr:"+lgestPalindicStr);
	}
	
}
