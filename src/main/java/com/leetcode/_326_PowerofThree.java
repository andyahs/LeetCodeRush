package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/4 14:59
 * coding For love and Peace
 */
//验证一个数是否是3的幂
public class _326_PowerofThree {
    public boolean isPowerOfThree(int n) {
//        double tem = Math.log10(n) / Math.log10(3);
//        return (tem - (int)(tem)) == 0?true:false;
        //各种循环法
        if (n<1)
            return false;
        while (n %3== 0 ){
            n /=3;
        }
        return n == 1;
    }
}
