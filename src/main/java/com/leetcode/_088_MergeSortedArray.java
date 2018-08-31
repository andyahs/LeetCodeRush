package com.leetcode;


/**
 * Created by Andiz
 * 2018/8/31 10:24
 * coding For love and Peace
 */
public class _088_MergeSortedArray {
    public static void merge(int nums1[], int m, int nums2[], int n){
        int []C = new int[m+n];
        //暴力遍历
        int aIdx = 0;
        int bIdx = 0;
        if (m==0)   System.arraycopy(nums2,0,C,0,m+n);
        for (int cur = 0;cur <m+n-1&&aIdx<m&&bIdx<n;cur++){
            if (nums1[aIdx] <= nums2[bIdx]) {
                C[cur] = nums1[aIdx];
                aIdx++;
            }else {
                C[cur] = nums2[bIdx];
                bIdx ++;
            }
            if (cur ==Integer.MAX_VALUE) break;
            //考虑可能a或者b先遍历玩 所以剩下的可以直接copy到c
            if (aIdx ==m && bIdx ==n) break;
            if (aIdx >=m) {
                System.arraycopy(nums2,bIdx,C,cur+1,n-bIdx);
                break;
            }
            if (bIdx >=n){
                System.arraycopy(nums1,aIdx,C,cur+1,m-aIdx);
                break;
            }
        }
        if(n!=0)    System.arraycopy(C,0,nums1,0,m+n);

    }

    public static void main(String[] args) {
        int[] a={0,0,0,0};
        int[] b={1,2,3,4};
        merge(a,0,b,4);
        System.out.println(a[a.length-1]);
    }
}
