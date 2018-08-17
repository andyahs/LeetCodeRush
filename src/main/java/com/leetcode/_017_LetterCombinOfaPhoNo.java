package com.leetcode.www;

import java.util.Iterator;
import java.util.LinkedList;

public class _017_LetterCombinOfaPhoNo {
	public static LinkedList<String> letterCombin(String digts){
		LinkedList<String> res =new LinkedList<String>();
		LinkedList<String> out =new LinkedList<String>();
		if(digts.isEmpty()) return  res;
		String dict[] = {"adc","def","ghi","jkl","mno","pqrs","tuv","xyz"};
		letterCombinationsDFS(digts,dict,0,out,res);
		return res;
		
	}
	public static void letterCombinationsDFS(String digts,String[] dict,int level,LinkedList<String> out,LinkedList<String> res){
		if(level ==digts.length()) {
		
			String tempStr = out.toString();
			String tS2 = "";
			for(int i = 0; i<tempStr.length(); i++){
				tS2 +=tempStr.charAt(tempStr.length()-1-i);
			}
			res.push(tS2);
		
//			res.push(out.toString());
		}else{
			String str= dict[digts.charAt(level) - '2'];
			for(int i = 0; i<str.length(); i++){
				String temp  = Character.toString(str.charAt(i));
				out.push(temp);
				letterCombinationsDFS(digts, dict, level+1, out, res);
				out.pop();
			}
		}
		
	}
	public static void main(String[] args) {
		String digts = "2345678";
		LinkedList<String> letter = letterCombin(digts);
		for(String str:letter){
			System.out.println(str.toString());
		}
	}
}
