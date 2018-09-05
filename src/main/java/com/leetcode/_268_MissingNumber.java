package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/5 16:21
 * coding For love and Peace
 */
public class _268_MissingNumber {
    public int missingNumber(int[] nums) {
//        boolean[] flags  =new boolean[nums.length+1];
//        int res= 0;
//        for(int i=0; i<nums.length; i++){
//            flags[nums[i]] = true;
//        }
//        for(int i=0; i<flags.length; i++){
//            if(flags[i] ==false){
//                res = i;
//            }
//        }
//        return res;
        //要求你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
        //所以按照之前的思路，可以用异或来做
        int res = 0;
        for (int i=0;i<nums.length;i++){
            res ^=nums[i];
            res ^=i;
        }
        res ^= nums.length;
        return res;
    }
}
