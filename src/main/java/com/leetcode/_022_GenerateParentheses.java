package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//生成括号
/*
022生成括号
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]


 */
public class _022_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n==0) return res;
        int left= 0,right =0;
        char[] curStr = new char[2*n];
        addParentheses(res,curStr,left,right,n);
        return res;
    }


    private void addParentheses(List<String> res,char[] preStr,int left,int right,int n){
        if (left+right ==2*n){
            res.add(String.valueOf(preStr));
            return ;
        }
        if (left <n) {
            preStr[left+right]= '(';
            addParentheses(res,preStr,left+1,right,n);
        }
        if (right<left){
            preStr[left+right]= ')';
            addParentheses(res,preStr,left,right+1,n);
        }
    }


//    public List<String> generateParenthesis(int n) {
//        Set<String> res = new HashSet<String>();
//        if (n == 0) {
//            res.add("");
//        } else {
//            List<String> pre = generateParenthesis(n - 1);
//            for (String str : pre) {
//                for (int i = 0; i < str.length(); ++i) {
//                    if (str.charAt(i) == '(') {
//                        str = str.substring(0, i + 1) + "()" + str.substring(i + 1, str.length());
//                        res.add(str);
//                        str = str.substring(0, i + 1) +  str.substring(i + 3, str.length());
//                    }
//                }
//                res.add("()" + str);
//            }
//        }
//        return new ArrayList(res);
//    }


    //暴力硬核写法 递归在各个位置加()
//    public List<String> hardCoreinit(int n){
//        Set<String> res = new HashSet<String>();
//        String oriStr = "";
//        res.add(oriStr);
//        res = hardCoreSolution( n-1, res);
//
//        return new ArrayList(res);
//
//    }
//
//    public Set<String>hardCoreSolution(int n,Set<String> res){
//        Set<String> pre = new HashSet<String>();
//    	if(n>=1)
//    		res = hardCoreSolution(n-1, res);
//    	for(String str:res){
//    		for(int i=0;i<str.length();i++){
//    			if(str.charAt(i)=='('){
//    				str = str.substring(0, i+1)+"()"+str.subSequence(i+1, str.length());
//    				pre.add(str);
//    				str = str.substring(0, i+1)+str.subSequence(i+3, str.length());
//    			}
//    		}
//            pre.add("()" + str);
//    	}
//    	return pre;
//    }

    //leetcode提供
    //    public List<String> generateParenthesis(int n) {
    //        if (n ==0)return null;
    //        ArrayList<String> list = new ArrayList<>();
    //        def(0,0,list,new char[n*2],n);
    //        return list;
    //    }
    //
    //    public void def(int left,int right,ArrayList<String> list,char[] buffer,int n){
    //        if (left+right ==2*n){
    //            list.add(String.copyValueOf(buffer));return;
    //        }
    //        if (left<n){
    //            buffer[left+right]='(';
    //            def(left+1,right,list,buffer,n);
    //        }
    //        if (left>right){
    //            buffer[left+right]=')';
    //            def(left,right+1,list,buffer,n);
    //        }
    //    }
    
    public _022_GenerateParentheses(){};
    
    public static void main(String[] args) {
		int n =3;
		_022_GenerateParentheses test1 = new _022_GenerateParentheses();
		ArrayList<String> arrList = (ArrayList<String>) test1.generateParenthesis(n);
//		ArrayList<String> arrList = (ArrayList<String>) test1.hardCoreinit(n);
		for(String str:arrList){
			System.out.println(str);
		}
		
	}
}
