package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/17 14:05
 * coding For love and Peace
 */
// 旋转数组
public class _189_RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }

        k = k % nums.length;
        int lenLeftEnd = nums.length - k - 1;
        int lenRightBeg = lenLeftEnd+1;
        reverse(nums, 0, lenLeftEnd);
        reverse(nums, lenRightBeg, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
