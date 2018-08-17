package com.leetcode.www;

import java.util.Arrays;

public class _027_RemoveElement {
    public static int removeElement(int [] nums,int val){
        int cur = 0;
        int pre = 0;
        for(int count=0;count<nums.length;count++){
            if(nums[count] !=val) nums[pre++] = nums[count];
        }
        int [] newArray = Arrays.copyOfRange(nums,0,pre);
        System.out.println(Arrays.toString( newArray));
        return pre;
    }


    public static void main(String[] args) {
        int []a  = {1,2,2,2,5,6,7,9};
        System.out.println(removeElement(a,2));

    }
}
