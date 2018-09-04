package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/4 10:50
 * coding For love and Peace
 */
//找小于n的质数个数，主要问题在于不包含本身，本身不计数。
//我想到的魔道方法还有查表法
//然后我看了0ms的switch。。。
public class _204_CountPrimes {
    public static int countPrimes(int n) {
        int count  =0;
        if (n <= 2) return 0;
        if (n == 3) return 1;
        if (n <= 5) return 2;
        if (n <= 7) return 3;
        if (n <= 11) return 4;
        count =4;
        boolean[] nums = new boolean[n+1];
        int limit = (int) Math.sqrt(n);

        for (int i = 2; i<=limit; i++){
            if (!nums[i]){
                for (int j = i*i ; j<= n; j+=i){
                    nums[j] = true;
                }
            }
        }

        for (int j = 11; j < n ; ++j) {
            if (!nums[j]) ++count;
        }

        return count;
    }

    public static void main(String[] args) {
        int n =98;
        boolean[] nums = new boolean[n-1];
        System.out.println(countPrimes(n));
    }
}
