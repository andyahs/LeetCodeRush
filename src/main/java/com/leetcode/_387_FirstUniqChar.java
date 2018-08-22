package com.leetcode;

import java.util.HashMap;

/**
 * Created by Andiz
 * 2018/8/22 11:11
 * coding For love and Peace
 */
public class _387_FirstUniqChar {
    public static int firstUniqChar(String s){
        if (null == s){
            return -1;
        }
        if (s.length()==1){
            return 0;
        }

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            map.put(c,null != map.get(c)? map.get(c)+1 : 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) ==1)
                return i;
        }

        return -1;
        //leetcode的老哥用了暴力查找，字符串一旦够长就不可取
//        int result = -1;
//        for(char c = 'a';c<='z';c++){
//            int index = s.indexOf(c);
//            if(index != -1 && index == s.lastIndexOf(c)){
//                result = result != -1?Math.min(result,index):index;
//            }
//        }
//        return result;

    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
