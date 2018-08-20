package com.leetcode;

import java.util.Arrays;

/**
 * Created by Andiz
 * 2018/8/20 14:39
 * coding For love and Peace
 */
public class _283_MoveZeros {
    public static  void  moveZeroes(int[] nums){

//        for (int i=0;i<nums.length;i++){
//            if (0 == nums[i]){
//                for (int j=i+1;j<nums.length;j++){
//                    if (0 !=nums[j]){
//                        nums[i] = nums[j];
//                        nums[j] = 0;
//                        break;
//                    }
//                    if (j == nums.length-1){
//                        i=nums.length;
//                    }
//                }
//            }
//
//        }
        if (null == nums||nums.length<=1){

        }else {
            int countNot0 = 0;
            for (int i =0; i <nums.length;i++){
                if (0!=nums[i] ){
                    nums[countNot0] = nums[i];
                    countNot0++;
                }
            }
            for (int i=nums.length-1; i>countNot0-1; i--){
                nums[i] =0;
            }
        }

    }


    public static void main(String[] args) {
        int []nums  ={1,0,1,0,2,10,5,0,19};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
