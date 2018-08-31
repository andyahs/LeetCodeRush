package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/31 14:37
 * coding For love and Peace
 */
public class _278_FirstBadVersion {
    public static int findFirstBadVersion(int n) {
    //简单的二分查找 但是由于有这样的测试案例"2126753390,1702766719,"，所以需要写成int mid = left + (right - left) / 2;
        //当然 很显然 还有迭代版本
        int left =1,right = n;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }


    public static boolean isBadVersion(int  idx){
        //是错误版本
         if (idx >= 1702766719)return true;

         return false;
    }

    public static void main(String[] args) {
        int n = 2126753390;
        System.out.println(findFirstBadVersion(n));
    }
}
