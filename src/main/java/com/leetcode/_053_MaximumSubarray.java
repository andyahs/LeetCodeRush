package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/1 23:31
 * coding For love and Peace
 */
//找最大子数组
public class _053_MaximumSubarray {
    int maxSubArray(int []nums) {
        if (null == nums) return 0;
        if (nums.length == 1) return nums[0];
        //可以直接遍历 即O(n)
        int res = Integer.MIN_VALUE,curSum = 0;
        for (int val: nums){
            curSum = Math.max(curSum+val,val);
            res = Math.max(res,curSum);
        }
        return res;
        //也可以用分治的思想 O(nlogn)

    }


}
