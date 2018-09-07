package com.leetcode;

import java.util.*;

/**
 * Created by Andiz
 * 2018/9/7 10:59
 * coding For love and Peace
 */
//输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
public class _049_Anagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (null==strs) return res;
        Map<String,List> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String curStr = strs[i];
            String curLowStr = curStr.toLowerCase();
            char[] curLowChar = curLowStr.toCharArray();
            Arrays.sort(curLowChar);
            curLowStr = String.valueOf(curLowChar);
            if (map.containsKey(curLowStr)){
                map.get(curLowStr).add(curStr);
            }else {
                List<String> curList = new ArrayList<>();
                curList.add(curStr);
                map.put(curLowStr,curList);
            }
        }
        for (String key: map.keySet()
             ) {
            res.add(map.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs= {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        List<List<String>> res = groupAnagrams(strs);
    }

}
