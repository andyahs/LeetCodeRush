package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andiz
 * 2018/8/17 14:54
 * coding For love and Peace
 */
//存在重复
public class _217_ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        //测试用例是不是已经是有序递增数组了？
        if (null ==nums || 0==nums.length) return false;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j])
                {
                    break;
                }
                else if(nums[i] == nums[j])
                {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int []a  ={3,2,1,4,5,3};
        System.out.println(containsDuplicate(a));
    }
}
