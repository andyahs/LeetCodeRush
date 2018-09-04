package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andiz
 * 2018/9/4 10:15
 * coding For love and Peace
 */
public class _412_FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> listFB = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i %15 ==0) {
                listFB.add("FizzBuzz");
            }else if (i%3 ==0){
                listFB.add("Fizz");
            }else if (i%5 == 0){
                listFB.add("Buzz");
            }else listFB.add(Integer.toString(i));//这里我oj时候发现toString方法比i+""迅速
        }
        return listFB;
        //看到了return new java.util.AbstractList<String>(){}这个骚操作。。。
    }

    public static void main(String[] args) {
        int n=15;
        List<String> listFB =fizzBuzz(n);
        for (int i = 0; i < n; i++) {
            System.out.println(listFB.get(i));
        }
    }
}
