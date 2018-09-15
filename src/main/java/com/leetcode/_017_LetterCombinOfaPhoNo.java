package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _017_LetterCombinOfaPhoNo {

	//定义每个数字对应的字符
	static String[] a = new String[] {"","","abc","def",
			"ghi","jkl","mno","pqrs","tuv","wxyz"};
	static StringBuffer sb = new StringBuffer();

	public static List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return new ArrayList<String>();
		}
		List<String> answer = new ArrayList<String>();

		//开始回溯
		zuhe(digits , 0 , answer);
		return answer;
	}

	private static void zuhe(String digits , int n, List<String> answer) {
		if (n == digits.length()) {
			answer.add(sb.toString());
			return;
		}
		for (int i = 0; i < a[digits.charAt(n)-'0'].length(); i++) {
			sb.append(a[digits.charAt(n)-'0'].charAt(i));
			zuhe(digits, n + 1, answer);
			sb.deleteCharAt(sb.length() - 1);
		}
	}


	public static void main(String[] args) {
		String digts = "";
		List<String> letter = letterCombinations(digts);
		for(String str:letter){
			System.out.println(str.toString());
		}
	}
}
