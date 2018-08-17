package com.leetcode.www;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//��������
public class _022_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<String>();
        if (n == 0) {
            res.add("");
        } else {
            List<String> pre = generateParenthesis(n - 1);
            for (String str : pre) {
                for (int i = 0; i < str.length(); ++i) {
                    if (str.charAt(i) == '(') {
                        str = str.substring(0, i + 1) + "()" + str.substring(i + 1, str.length());
                        res.add(str);
                        str = str.substring(0, i + 1) +  str.substring(i + 3, str.length());
                    }
                }
                res.add("()" + str);
            }
        }
        return new ArrayList(res);
    }
    
    public List<String> hardCoreinit(int n){
        Set<String> res = new HashSet<String>();
        String oriStr = "";
        res.add(oriStr);
        res = hardCoreSolution( n-1, res);
        
        return new ArrayList(res);
    	
    }
    public Set<String>hardCoreSolution(int n,Set<String> res){
        Set<String> pre = new HashSet<String>();
    	if(n>=1)
    		res = hardCoreSolution(n-1, res);
    	for(String str:res){
    		for(int i=0;i<str.length();i++){
    			if(str.charAt(i)=='('){
    				str = str.substring(0, i+1)+"()"+str.subSequence(i+1, str.length());
    				pre.add(str);
    				str = str.substring(0, i+1)+str.subSequence(i+3, str.length());
    			}
    		}
            pre.add("()" + str);
    	}
    	return pre;
    }
    
    
    public _022_GenerateParentheses(){};
    
    public static void main(String[] args) {
		int n =3;
		_022_GenerateParentheses test1 = new _022_GenerateParentheses();
//		ArrayList<String> arrList = (ArrayList<String>) test1.generateParenthesis(n);
		ArrayList<String> arrList = (ArrayList<String>) test1.hardCoreinit(n);
		for(String str:arrList){
			System.out.println(str);
		}
		
	}
}
