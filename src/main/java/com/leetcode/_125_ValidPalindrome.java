package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/23 23:13
 * coding For love and Peace
 */
public class _125_ValidPalindrome {
    //验证回文字符串
    public static boolean isPalindrome(String s){
//        if (null ==s ) return false;
//        if (s.length() <=1) return true;
//        int left = 0;
//        int right = s.length()-1;
//        while(left <  right){
//            System.out.println(s.charAt(left) +"  "+ s.charAt(right));
//            if (!isAlphaNum(s.charAt(left))) left++;
//            else if (!isAlphaNum(s.charAt(right))) right--;
//            else if ( (s.charAt(left) + 32 - 'a') %32 != (s.charAt(right) + 32 - 'a') % 32 ) return false;
//            else {
//                left++;right--;
//            }
//        }
//        return true;
        //leetcode提供的算法
        char[] sArray=s.toCharArray();
        int[] res=new int[sArray.length];
        int length=0;
        for(int i=0;i<sArray.length;i++){
            if(sArray[i]!=' '){
                int gapB=sArray[i]-'A';
                int gapS=sArray[i]-'a';
                if(gapB>=0 && gapB<=25){
                    res[length++]=gapB+10;
                }else if(gapS>=0 && gapS<=25){
                    res[length++]=gapS+10;
                }else if(sArray[i]>='0' && sArray[i]<='9'){
                    res[length++]=sArray[i]-'0';
                }
            }
        }
        int start=0;
        int end=length-1;
        while(start<end){
            if(res[start]!=res[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isAlphaNum(char ch) {
        if (ch >= 'a' && ch <= 'z') return true;
        if (ch >= 'A' && ch <= 'Z') return true;
        if (ch >= '0' && ch <= '9') return true;
        return false;
    }

    public static void main(String[] args) {
        String s ="race a car";

        System.out.println(isPalindrome(s));

    }
}
