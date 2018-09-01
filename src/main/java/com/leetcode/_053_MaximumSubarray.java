package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/1 23:31
 * coding For love and Peace
 */
//找最大子数组
public class _053_MaximumSubarray {
//    int maxSubArray(int []nums) {
//        if (null == nums) return 0;
//        if (nums.length == 1) return nums[0];
//        //可以直接遍历 即O(n)
//        int res = Integer.MIN_VALUE,curSum = 0;
//        for (int val: nums){
//            curSum = Math.max(curSum+val,val);
//            res = Math.max(res,curSum);
//        }
//        return res;
//        //也可以用分治的思想 O(nlogn)
//    }


    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }
    public int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = left + (right - left) / 2;
        int lmax = helper(nums, left, mid - 1);
        int rmax = helper(nums, mid + 1, right);
        int mmax = nums[mid], t = mmax;
        for (int i = mid - 1; i >= left; --i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        t = mmax;
        for (int i = mid + 1; i <= right; ++i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }

}
