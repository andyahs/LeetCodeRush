package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/16 14:19
 * coding For love and Peace
 */
public class _0150_BestBuy2 {
    public static int buy(int a[]){

        int size = a.length;
        if(size <= 0) {
            return 0;
        }

        int max = 0;
        for(int i=1; i<size; i++) {
            if(a[i] - a[i-1] > 0) {
                max += (a[i] - a[i-1]);
            }
        }
        return max;
    }
}
