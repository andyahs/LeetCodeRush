package com.leetcode;

import java.math.BigInteger;

/**
 * Created by Andiz
 * 2018/9/4 15:44
 * coding For love and Peace
 */
public class _191_Numberof1Bits {
//>>右移运算符，有符号。右边超出截掉，左边补上符号位
//
//
//>>>右移运算符，无符号，左边补0
    public static int hammingWeight(int n) {
        //由于有超过int范围的数，所以用按位与0x1来做。 同时由于右移，所以使用>>>，右移左边补零
        int res = 0;
        while (n != 0){
            res += n &0x1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 0b10000000000000000000000000000000;
        System.out.println(hammingWeight(n));
    }
}
