package com.leetcode;


import java.util.Arrays;

public class _026_RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int [] nums) {
        if (nums.length == 0) return 0;
        int id = 0;
        for (int i=0; i<nums.length;i++) {
            if (nums[i]!=nums[id]){
                id++;
                nums[id] = nums[i];
            }
        }
        return ++id;
    }


    public static void main(String[] args) {
        int [] a ={2,2,5,7,8,9,12,12,12,15};
        int x = removeDuplicates(a);
        System.out.println(x);
    }
}

