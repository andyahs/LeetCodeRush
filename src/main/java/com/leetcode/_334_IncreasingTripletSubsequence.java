package com.leetcode;


/**
 * Created by Andiz
 * 2018/9/8 15:56
 * coding For love and Peace
 * 334递增的三元子序列 Increasing Triplet Subsequence
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 *     如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 *     使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class _334_IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        if (null==nums ||nums.length<=2) return false;
        int left = nums[0],mid=Integer.MAX_VALUE;
        //本质上用左和中构成了一把尺，找出最低和次低的两个点。
        for (int curValue:nums) {
            if (curValue<left){
                left = curValue;
            }else if (left <curValue && curValue <mid){
                mid = curValue;
            }else if (mid <curValue){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int [] nums ={5,4,3,2,1};
        //[2,4,-2,-3]
//        int [] nums ={2,4,-2,-3};
        int [] nums ={1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
    }
}
