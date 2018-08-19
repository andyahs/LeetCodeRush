package com.leetcode;

import java.util.*;
/**
 * Created by Andiz
 * 2018/8/20 0:33
 * coding For love and Peace
 */
public class _350_IntersectionofTwoArraysII {
    //一种用排序法做的，一种用map做的
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> tmp = new ArrayList<Integer>();
        if (nums1.length>=nums2.length){
            tmp=createList(nums1,nums2);
        }else {
            tmp= createList(nums2,nums1);
        }
        int[] result = new int [tmp.size()];
        for (int i=0; i<tmp.size();i++){
            result[i] = tmp.get(i);
        }

        return result;
    }

    public static List<Integer> createList(int [] arrLon,int[] arrShort){
        List<Integer> tmp = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i: arrLon){
            if (!map.containsKey(i)){
                map.put(i,1);
            }else {
                map.put(i,map.get(i)+1);
            }
        }
        for (int i:arrShort){
            if (map.containsKey(i) && map.get(i)!=0){
                tmp.add(i);
                map.put(i,map.get(i)-1);
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }
}
