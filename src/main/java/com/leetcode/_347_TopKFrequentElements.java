package com.leetcode;

import java.util.*;

/**
 * Created by Andiz
 * 2018/9/21 22:30
 * coding For love and Peace
 *347. 前K个高频元素
 *给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 说明：
 *     你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *     你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class _347_TopKFrequentElements {
    //主要思路是桶排序
    class Pair{
        int num;
        int count;
        public Pair(int num, int count){
            this.num=num;
            this.count=count;
        }
    }

//    public List<Integer> topKFrequent(int[] nums, int k) {
//        //count the frequency for each element
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for(int num: nums){
//            if(map.containsKey(num)){
//                map.put(num, map.get(num)+1);
//            }else{
//                map.put(num, 1);
//            }
//        }
//
//        // create a min heap
//        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>(){
//            public int compare(Pair a, Pair b){
//                return a.count-b.count;
//            }
//        });
//
//        //maintain a heap of size k.
//        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//            Pair p = new Pair(entry.getKey(), entry.getValue());
//            queue.offer(p);
//            if(queue.size()>k){
//                queue.poll();
//            }
//        }
//
//        //get all elements from the heap
//        List<Integer> result = new ArrayList<Integer>();
//        while(queue.size()>0){
//            result.add(queue.poll().num);
//        }
//        //reverse the order
//        Collections.reverse(result);
//
//        return result;
//    }

    //leetcode提供思路
       public static List<Integer> topKFrequent(int[] nums, int k) {
            if (nums == null || nums.length == 0) return null;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i : nums) {
                if (i < min) min = i;
                if (i > max) max = i;
            }

            int[] count = new int[max - min + 1];   // 各个数字出现的频数

            for (int i : nums) {
                count[i - min]++;
            }

            int max_count = Integer.MIN_VALUE;
            //找出最高频率数
            for (int i : count) {
                if (i > max_count)
                    max_count = i;
            }

            int[] aid = new int[max_count + 1];   // 各个频数所包含的key数
            //比如出现过1次的三个，出现过两次的2两个
            for (int i : count) {
                if (i > 0) {
                    aid[i]++;
                }
            }
            //得出哪些频数需要输出即最低频数是多少
            int min_count = 1;
            int curr = 0;
            for (int i = aid.length - 1; i >= 1; i--) {
                if (aid[i] > 0) {
                    curr += aid[i];//累积从高到低需要输出的频率
                    if (curr >= k) {
                        min_count = i;
                        break;
                    }
                }
            }
            //然后从count[i]>最低频数，加入到结果集中
            List<Integer> ans = new ArrayList<>(k);
            for (int i = 0; i < count.length; i++) {
                if (count[i] >= min_count) {
                    ans.add(i + min);
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        int []nums = {4,1,-1,2,-1,2,3};
        List<Integer> reslist=  topKFrequent(nums,2);

    }

}
