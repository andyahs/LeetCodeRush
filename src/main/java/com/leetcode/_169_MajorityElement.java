package com.leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Andiz
 * 2018/10/15 15:19
 * coding For love and Peace
 * 169求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class _169_MajorityElement {
    //除了hashmap，还可以用摩尔投票法
    public int majorityElement(int[] nums) {
        if (null ==nums ||nums.length  <=1) return nums[0];
        HashMap<Integer,Integer> cntMap = new HashMap<>();
        for (int i =0; i<nums.length ;i++){
            if (cntMap.containsKey(nums[i])){
                cntMap.put(nums[i], cntMap.get(nums[i])+1);
            }else {
                cntMap.put(nums[i],1);
            }
            if (cntMap.get(nums[i]) >nums.length/2) return nums[i];
        }
        return -1;
    }
}
