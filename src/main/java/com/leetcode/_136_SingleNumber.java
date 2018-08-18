package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/18 22:34
 * coding For love and Peace
 */
public class _136_SingleNumber {

    public static int singleNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        if (nums.length==1) return nums[0];
        int x =nums[0];
        for (int i =1;i<nums.length;i++){
            x = x^nums[i];
        }
        return x;
    }

    public static void main(String[] args) {
        int []a ={1,2,3,3,2,1,16};
        System.out.println(singleNumber(a));
    }

}
