package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/24 23:25
 * coding For love and Peace
 * 034在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class _034_SearchforaRange {
    public static int[] searchRange(int[] nums, int target) {
        int res[] = {-1,-1};
        if (null ==nums|| nums.length ==0) return res;
        int left =0,right =nums.length-1;
        while (left <right){
            int mid = (left+right)/2;
            if ( nums[mid] <target) left = mid+1;
            else right = mid;
        }
        if (nums[right] !=target) return res;
        res[0] =right;
        right = nums.length; //这里用了特殊的没有+1,正好滤过了{0}中找0这种情况
        while (left <right){
            int mid = (left+right) /2;
            if (nums[mid] >target) right = mid;
            else left =mid+1 ;
        }
        res[1] = left-1;
        return res;



//        int[] res = new int[2];
//        res[0] = -1;
//        res[1] = -1;
//        if (null == nums || nums.length ==0) return res;
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] < target) left = mid + 1;
//            else right = mid;
//        }
//        if (nums[right] != target) return res;
//        res[0] = right;
//        right = nums.length;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] <= target) left = mid + 1;
//            else right= mid;
//        }
//        res[1] = left - 1;
//        return res;
    }

    //LeetCode提供
    //    public int[] searchRange(int[] nums, int target) {
    //        int[] result = new int[2];
    //        if (nums == null || nums.length == 0 || target < 0) {
    //            result[0] = -1;
    //            result[1] = -1;
    //            return result;
    //        }
    //
    //        result[0] = findFirst(nums, target);
    //        result[1] = findLast(nums, target);
    //
    //        return result;
    //    }
    //    public int findFirst (int[] nums,int target) {
    //        int index = -1;
    //        int low = 0;
    //        int high = nums.length - 1;
    //        int mid;
    //
    //        while(low <= high) {
    //            mid = (low + high) >> 1;
    //
    //            if (nums[mid] > target) {
    //                high = mid - 1;
    //            } else if (nums[mid] < target) {
    //                low = mid + 1;
    //            } else {
    //                index = mid;
    //                high = mid - 1;
    //            }
    //        }
    //
    //        return index;
    //    }
    //    public int findLast (int[] nums,int target) {
    //        int index = -1;
    //        int low = 0;
    //        int high = nums.length - 1;
    //        int mid;
    //
    //        while(low <= high) {
    //            mid = (low + high) >> 1;
    //
    //            if (nums[mid] > target) {
    //                high = mid - 1;
    //            } else if (nums[mid] < target) {
    //                low = mid + 1;
    //            } else {
    //                index = mid;
    //                low = mid + 1;
    //            }
    //        }
    //
    //        return index;
    //    }


    public static void main(String[] args) {
        int[] nums = {0};
        searchRange(nums,0);
        System.out.println((0+1)/2);
    }
}
