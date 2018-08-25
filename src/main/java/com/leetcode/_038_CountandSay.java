package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/25 14:34
 * coding For love and Peace
 */
public class _038_CountandSay {
    //数数并说
    public static String countAndSay(int n) {
        if (n <= 0) return "";
        String res = "1";
        while ( --n >0 ) {
            StringBuilder  cur =new StringBuilder() ;
            for (int i = 0; i < res.length(); ++i) {
                int cnt = 1;
                while (i + 1 < res.length() && res.charAt(i) == res.charAt(i+1)) {
                    ++cnt;
                    ++i;
                }
                cur.append( Integer.toString(cnt) + res.charAt(i));
            }
            res = cur.toString();
        }
        return res;
        //最快解法 直接查表
    }

    public static void main(String[] args) {
        int n =1;
        System.out.println(countAndSay(3));
    }
}
