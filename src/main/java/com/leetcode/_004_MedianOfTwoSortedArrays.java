package com.leetcode;

public class _004_MedianOfTwoSortedArrays {
	
	public static double findMedian(int[] nums1 ,int[] nums2 ){
		int m = nums1.length;
		int n = nums2.length;
		if( m <n ) return findMedian(nums2, nums1);
		if(n == 0) return (nums1[(m-1)/2])+nums1[(m/2)]/2.0;
		int left = 0,right= 2*n;
		while(left <= right){
			int mid2 = (left+right)/2;
			int mid1 = m+n -mid2;
			double L1 = mid1 ==0 ? Double.MIN_VALUE: nums1[(mid1 -1)/2];
			double L2 = mid2 ==0 ? Double.MIN_VALUE: nums2[(mid2 -1)/2];
			double R1 = mid1 == m*2 ?Double.MAX_VALUE:nums1[mid1/2];
			double R2 = mid2 == n*2 ?Double.MAX_VALUE:nums2[mid2/2];
			if(L1 >R2) 
				left = mid2+1;
			else if(L2>R1)
				right = mid2 - 1;
			else return (Math.max(L1, L2) + Math.min(R1, R2))/2;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int [] nums1 = {1,2,18,29,30};
		int [] nums2 = {3,4,6,9,31,32,44};
		double median = findMedian(nums1, nums2);
		System.out.println("nums1:");
		for(int i =0;i<nums1.length;i++){
			System.out.print(nums1[i]+" ");
		}
		System.out.println("\n"+"nums2:");
		for(int i =0;i<nums2.length;i++){
			System.out.print(nums2[i]+" ");
		}
		System.out.println("median:"+median);
		
	}
}
