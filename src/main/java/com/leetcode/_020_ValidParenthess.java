package com.leetcode;

import java.util.Stack;
//20有效的括号
//用栈只遍历一遍
//貌似也可以用数组，左右两个烧饼验证
public class _020_ValidParenthess {
	public static boolean isValid(String s){
		boolean flag = true;
		Stack<Character> charStack = new Stack<Character> ();
		char[] charArr = s.toCharArray();
		for(int i = 0; i<charArr.length;i++){
			if(charArr[i]=='('||charArr[i]=='{'||charArr[i]=='['){
				charStack.push(charArr[i]);
			}else if(charArr[i]==')'||charArr[i]=='}'||charArr[i]==']'){
				if(charStack.isEmpty()) return false;
				if(charArr[i]==')'&&charStack.pop()!='(') return false;
				if(charArr[i]==']'&&charStack.pop()!='[') return false;
				if(charArr[i]=='}'&&charStack.pop()!='{') return false;
			}else{
				System.out.print("这个非括号"+charArr[i]+" ");
			}
		}
		if (!charStack.isEmpty()) return  false;
		return flag;
	}
	public static void main(String[] args) {
		String str = "$%{";
		System.out.println(isValid(str));
	}
	
}
