package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/31 15:16
 * coding For love and Peace
 */
public class _070_ClimbingStairs {

    //爬楼梯 主要玩动态规划
//    arr[step ] = arr[step -1] +s[step -2];
    //用递归可能直接爆了
    public static int climbStairs(int n) {
        if(n<=2) return n;
        int steps[] = new int[n+1];
        steps[1] = 1;
        steps[2] = 2;
        //也可以不用数组，直接用 a=b+c; c =b; b =a;(初始化分别为021)
        for(int i=3;i<n+1;i++)
            steps[i] = steps[i-1]+steps[i-2];
        return steps[n];
    }
}
