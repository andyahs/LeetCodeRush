package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andiz
 * 2018/9/5 15:24
 * coding For love and Peace
 */
public class _118_PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> data = new ArrayList<>();
        if (numRows <=0) return data;
        if (numRows >=1){
            List<Integer> curList = new ArrayList<>();
            curList.add(1);
            data.add(curList);
        }

        if (numRows >=2){
            List<Integer> curList = new ArrayList<>();
            curList.add(1);
            curList.add(1);
            data.add(curList);
        }
        if (numRows >=3){

            for (int i = 3; i <= numRows; i++) {
                List<Integer> perList = data.get(i-2);
                List<Integer> curList = new ArrayList<>();
                curList.add(1);
                for (int j = 2; j < i; j++) {
                    curList.add(perList.get(j-2)+perList.get(j-1));
                }
                curList.add(1);
                data.add(curList);
            }

        }

        return data;
    }

    public static void main(String[] args) {
        int n=5;
        generate(5);
    }
}
