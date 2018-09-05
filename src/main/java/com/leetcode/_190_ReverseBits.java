package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/5 9:48
 * coding For love and Peace
 */
//反转二进制 颠倒二进制位
public class _190_ReverseBits {
    public static int reverseBits(int n) {
        int res = 0;
        int i=0 ;
        while (i<32){
            res <<=1;
            res += n&0b1;
            n>>>=1;
            i++;
        }
        return res;

//当然看了网上的讨论 还有这个魔道方法，不过要注意的是java需要用>>>,c++用>>
//        n = (n >>> 16) | (n << 16);
//        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
//        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
//        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
//        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
//        return n;
    }

    //    43261596 (00000010100101000001111010011100)
    //   964176192 (00111001011110000010100101000000)

    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        System.out.println(reverseBits(n));

    }
}
