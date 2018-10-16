package com.leetcode;


import java.util.TreeSet;

/**
 * Created by Andiz
 * 2018/10/2 22:18
 * coding For love and Peace
 *
 * Longest Increasing Subsequence
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *     可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *     你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * 其他还有用数组，用stack等做法，可以二分法覆盖掉原来的相应的小数
 */
public class _300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set =  new TreeSet<>();
        for (int num :
                nums) {
            Integer ceil = set.ceiling(num);
            if (ceil != null) set.remove(ceil);
            set.add(num);
        }
        return set.size();
     }
}
