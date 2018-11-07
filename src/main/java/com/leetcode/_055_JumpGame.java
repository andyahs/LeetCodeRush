package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/28 21:16
 * coding For love and Peace
 *055跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 *
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置
 */
public class _055_JumpGame {

    public static boolean canJump(int[] nums) {
        if(null == nums || nums.length <=0) return false;
        int curIndex = 0,getRange =0;
        for (; curIndex < nums.length;curIndex++) {
            //内部再嵌套一个循环
            while (curIndex<nums.length-1 && getRange >nums[curIndex]+curIndex){
                curIndex++;
            }
            if (getRange>=nums.length-1) return true;
            if (curIndex >getRange) return false;
            getRange = Math.max(getRange,curIndex+nums[curIndex]);
        }
        return false;
    }


//    public boolean canJump(int[] nums) {
//        if(null == nums || nums.length <=0) return false;
//        int reach = 0;
//        for (int i = 0;i<nums.length ; i++){
//            if ( i >reach ||reach>nums.length-1) break;
//            reach = Math.max(reach,i+nums[i]);
//        }
//        return reach >=nums.length-1;
//    }

    //LeetCode提供
    //    public boolean canJump(int[] nums) {
    //        if(nums.length == 1){
    //            return true;
    //        }
    //        for(int i = nums.length-1; i > -1; i--){
    //            if(nums[i] == 0){
    //                int tmp = i--;
    //                //跳过与跳到
    //                int range = tmp == nums.length-1 ? tmp-1 : tmp;
    //                while(i > -1 && nums[i] <= range-i){
    //                    i--;
    //                }
    //                if(i == -1){
    //                    return false;
    //                }
    //            }
    //        }
    //        return true;
    //    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
