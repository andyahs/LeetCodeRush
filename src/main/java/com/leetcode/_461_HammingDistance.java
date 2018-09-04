package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/4 16:13
 * coding For love and Peace
 */
public class _461_HammingDistance {
    public static int hammingDistance(int x, int y) {
        int res = 0, exc = x ^ y;
        while (exc!=0){
            res +=exc & 0x1;
            exc >>>=1;
        }
        return res;
    }

    public static void main(String[] args) {
        int x =4,y=7;
        System.out.println(hammingDistance(x,y));
    }
}
