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
        if (null ==nums || 0==nums.length) return false;
        //用set leetcode 9ms
//        Set setContainer = new HashSet();
//        for (int a:nums){
//            if(!setContainer.add(a))return true;
//        }
        //用hashmap  leetcode 14ms
        Map<Integer,Integer> mapContainer = new HashMap<Integer, Integer>();
        for (int a:nums){
            if (mapContainer.containsKey(a)){
                return true;
            }else{
                mapContainer.put(a,1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int []a  ={1,2,3,1};
        System.out.println(containsDuplicate(a));
    }
}
