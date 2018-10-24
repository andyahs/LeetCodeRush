package com.leetcode;

import java.util.ArrayList;
import java.util.List;
/*
017电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

 */

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
	//    String[] codes = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	//    public List<String> letterCombinations(String digits) {
	//        if(digits == null || digits.equals("")){
	//            return new ArrayList<>();
	//        }
	//        List<String> result = new ArrayList<>();
	//        backtrace(digits, result, "", 1, digits.length());
	//        return result;
	//    }
	//
	//    private void backtrace(String digits, List<String> list, String str, int deep, int n){
	//        if(deep == n){
	//            for(char c : codes[digits.charAt(deep-1) - '0' -2].toCharArray()){
	//                list.add(str+c);
	//            }
	//        }else{
	//            for(char c : codes[digits.charAt(deep-1) - '0' -2].toCharArray()){
	//                backtrace(digits, list, str+c, deep+1, n);
	//            }
	//        }
	//    }


	public static void main(String[] args) {
		String digts = "";
		List<String> letter = letterCombinations(digts);
		for(String str:letter){
			System.out.println(str.toString());
		}
	}
}
