package com.leetcode;


import java.util.Arrays;

/**
 * Created by Andiz
 * 2018/8/20 9:43
 * coding For love and Peace
 */
public class _066_PlusOne {

    public static int[] plusOne(int[] digits){
//        if (null ==digits||digits.length == 0) return digits;
//        int sum=0;
//        int carry= 1;
//        int len = digits.length;
//        for (int i = 0; i<len;i++){
//            sum = carry+digits[len-1-i];
//            digits[len-1-i]=sum%10;
//            carry = sum>=10 ? 1:0;
//        }
//        int [] res = new int[len+1];
//        if (digits[0]==0){
//            res[0] = 1;
//            System.arraycopy(digits,0,res,1,len);
//        }
//        return digits[0]==0? res:digits;

        if (null ==digits||digits.length == 0) return digits;
        int len = digits.length;
        for (int i = len - 1; i > -1; i--) {
            if (digits[i] == 9 ) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        int[] newArray = new int[len + 1];
        newArray[0] = 1;
        return newArray;
    }

    public static void main(String[] args) {
        int []dig = {1,2,3};
        System.out.println(Arrays.toString(plusOne(dig)));
    }
}
