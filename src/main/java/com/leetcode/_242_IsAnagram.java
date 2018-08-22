package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/22 14:06
 * coding For love and Peace
 */
public class _242_IsAnagram {
    //字母异位词，两串所含字母种类和数量相同，只是位置不同
    public static boolean isAnagram(String s, String t){
        if (null ==s ||null ==t|| s.length()!=t.length()){
            return false;
        }
        int[] sArr = new int [26];
        int[] tArr = new int [26];
        for (int i=0; i<s.length();i++){
            sArr[s.charAt(i) - 97] ++;
            tArr[t.charAt(i) - 97] ++;
//            System.out.println(s.charAt(i)+" "+sArr[i] +" "+);
        }
        for (int i =0;i<26; i++){
            if(sArr[i] !=tArr[i] ){
                return false;
            }
        }
        return true;
        //看了leetcode的1ms写法，猜了测试案例。。顺便还只遍历了s，对t只做了contain
    }

    public static void main(String[] args) {
        String s ="anagram";
        String t= "nagaram";
        System.out.println(isAnagram(s,t));

        s = "rat";
        t = "car";
        System.out.println(isAnagram(s,t));
    }
}
