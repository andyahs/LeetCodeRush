package com.leetcode;

import java.util.Arrays;

//无重复字符的最长子串的长度
public class _003_LongestSubStr {

	public static int lengthOfLongestSubStr(String s){
		//这个奇葩方法就是用字符转码做下标，然后存储最后一个出现的位置
		//i-left得出目前字符串长度
		if (s.length()==1) return 1;
		int[] noRe = new int [256];
		//如果没被更新过，则左下标为max(left,-1)
		Arrays.fill(noRe,-1);
		int res = 0,left = -1;
		for(int i = 0 ;i<s.length();i++){
			//根据当前的char判断左边界是否要彼岸花
			left = Math.max(noRe[s.charAt(i)],left);
			//比较最大长度记录 如a123a  则4-0，所以为什么不是i-left+1
			res = Math.max(res,i-left);
			noRe[s.charAt(i)] = i;
		}

		return res;
		//        int n = s.length(), ans = 0;
		//        int[] index = new int[128]; // current index of character
		//        // try to extend the range [i, j]
		//        for (int j = 0, i = 0; j < n; j++) {
		//            i = Math.max(index[s.charAt(j)], i);
		//            ans = Math.max(ans, j - i + 1);
		//            index[s.charAt(j)] = j + 1;
		//        }
		//        return ans;
	}
	public static void main(String[] args) {
		int x =0;
//		String str1 = "abcabc1adc2";
		String str1 = "abcabcbb";
		x = lengthOfLongestSubStr(str1);
		System.out.println("x:"+x);
	}
}
