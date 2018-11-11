package com.leetcode;


import java.util.TreeSet;

/**
 * Created by Andiz
 * 2018/10/2 22:18
 * coding For love and Peace
 *
 *300最长上升子序列
 * Longest Increasing Subsequence
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *     可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *     你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * 其他还有用数组，用stack等做法，可以二分法覆盖掉原来的相应的小数
 */
public class _300_LongestIncreasingSubsequence {
    //两种算法的核心依然是构建二叉树
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set =  new TreeSet<>();
        for (int num :
                nums) {
            Integer ceil = set.ceiling(num);
            if (ceil != null) set.remove(ceil);
            set.add(num);
        }
        return set.size();
     }

     //LeetCode提供
    //    public int lengthOfLIS(int[] nums) {
    //        int n = nums.length;
    //        if(n==0){
    //            return 0;
    //        }
    //        if(n==1){
    //            return 1;
    //        }
    //        int[] dp = new int[n];
    //        int[] end = new int[n+1];
    //        end[1] = nums[0];
    //        int len = 1;
    //        for(int i=1;i<n;i++) {
    //            int ps = binary(end,1,len,nums[i]);
    //            end[ps] = nums[i];
    //            if(len < ps){
    //                len = ps;
    //            }
    //        }
    //        return len;
    //    }
    //
    //    public int binary(int[] arr,int s,int e,int val) {
    //        int mid;
    //        if(arr[e] < val) {
    //            return e+1;
    //        }
    //        while(s<e) {
    //            mid = s + (e-s) /2;
    //            if(arr[mid] < val) {
    //                s = mid + 1;
    //            } else {
    //                e = mid;
    //            }
    //        }
    //        return s;
    //    }
}
