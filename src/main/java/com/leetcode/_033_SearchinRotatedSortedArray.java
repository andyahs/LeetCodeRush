package com.leetcode;


/**
 * Created by Andiz
 * 2018/9/26 23:48
 * coding For love and Peace
 * 033搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class _033_SearchinRotatedSortedArray {
    //基本都是同一算法,主要要先比较target与nums[right]的大小，判断在左半部还是右半部
    public static int search(int[] nums, int target) {
        int left= 0,right= nums.length-1;
        while(left <= right){
            int mid = left+ (right - left)/2;
            if (nums[mid] ==target)
                return mid;
            else if (nums[mid] < nums[right]){
                if (nums[mid] <target && target <= nums[right])
                    left=  mid+1;
                else right= mid-1;
            }else {
                if (nums[left] <=target &&target<nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int idx = 0;
        System.out.println(search(nums,idx));
    }
}
