package com.leetcode.www;

import java.util.Stack;

public class _020_ValidParenthess {
	public static boolean isValid(String str){
		boolean flag = true;
		Stack<Character> charStack = new Stack<Character> ();
		char[] charArr = str.toCharArray();
		for(int i = 0; i<charArr.length;i++){
			if(charArr[i]=='('||charArr[i]=='{'||charArr[i]=='['){
				charStack.push(charArr[i]);
			}else if(charArr[i]==')'||charArr[i]=='}'||charArr[i]==']'){
				if(charStack.isEmpty()) return false;
				if(charArr[i]==')'&&charStack.pop()!='(') return false;
				if(charArr[i]==']'&&charStack.pop()!='[') return false;
				if(charArr[i]=='}'&&charStack.pop()!='{') return false;
			}else{
				System.out.print("�Ƿ���"+charArr[i]+" ");
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		String str = "$%{GFH(gfh[fdsgf)65]7}";
		System.out.println(isValid(str));
	}
	
}
