package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/22 9:43
 * coding For love and Peace
 */
public class _344_ReverseString {
    public static String reverseString(String s){
        if (null == s ||s.length()<=1){
            return s;
        }
//        char[] strArr = s.toCharArray();
//        char tmp;
//        for (int i= 0;i<(strArr.length)/2; i++){
//            tmp =strArr[i];
//            strArr[i] = strArr[strArr.length-1-i];
//            strArr[strArr.length-1-i] = tmp;
//        }
//        return String.valueOf(strArr);

        //直接新建数组
        char[] chars = s.toCharArray();
        char tmp ;
        for (int i= 0;i<(chars.length)/2; i++) {
            tmp = chars[i];
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "654321";
        System.out.println(s.length());
        System.out.println(reverseString(s));
    }
}
