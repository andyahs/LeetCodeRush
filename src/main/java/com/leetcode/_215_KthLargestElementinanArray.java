package com.leetcode;

import java.util.PriorityQueue;

/**
 * Created by Andiz
 * 2018/9/22 21:42
 * coding For love and Peace
 *在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class _215_KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        if(k > nums.length || k < 1)
            return Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i=0;i<k;i++) {
            pq.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }


//    public int findKthLargest(int[] nums, int k) {
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for(int i:nums){
//            if(i<min)min=i;
//            if(i>max)max=i;
//        }
//        int[] buffer = new int[max-min+1];
//        for(int i : nums){
//            buffer[i-min]+=1;
//        }
//        int cnt = 0;
//        int i = max-min;
//        for(; i>=0; i--){
//            cnt+=buffer[i];
//            if(cnt>=k)break;
//        }
//        return i+min;
//    }

}
