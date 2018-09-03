package com.leetcode;

import sun.security.util.Length;

import java.util.Random;

/**
 * Created by Andiz
 * 2018/9/3 15:14
 * coding For love and Peace
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
//384数组洗牌
public class _384_ShuffleAnArray {

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    private int[] ori ;
    private int[] cur ;

    public _384_ShuffleAnArray(int[] nums) {
        ori = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return ori;
    }

    /** Returns a random shuffling of the array. */
    //用Math.random()不行(取值[0,1) )，得用ran.nextInt()(取值[0,n));
    public int[] shuffle() {
        int len = ori.length;
        cur = new int[len];
        for(int i=0;i<len;i++)
            cur[i] = ori[i];

        Random ran = new Random();
        for (int i = 0; i <= len-1; i++) {
            // int t = ran.nextInt(len);
            int t = (int) (Math.random()*(len));//用math.random()问题在于强转的时候不要再用len-1，因为强转直接丢小数部分，不然就+0.5;
            int temp = cur[i];
            cur[i] = cur[t];
            cur[t] = temp;

        }
        return cur;
    }
}
