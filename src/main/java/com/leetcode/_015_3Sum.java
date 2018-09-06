package com.leetcode;



import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//a+b+c = 0
//without sort, print the same answer
//为了将O(n^3)压缩到O(n^2)，用了map，但是依然在超时的边缘试探。。。
public class _015_3Sum {

	public static List<List<Integer>> threeSum(int[] nums) {
		int target = 0;
		Arrays.sort(nums);
		List<List<Integer>> res =new ArrayList<>();

		HashMap<Integer, Integer> x = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			x.put(nums[i], i);
		}
		for(int i = 0; i<nums.length&& nums[i]<=0;i++){
			for(int j = i+1 ; j<nums.length-1 ; j++){
				if(x.get(target-nums[i]-nums[j])!= null && x.get(target-nums[i]-nums[j])>j ){
					List<Integer> curData = new ArrayList<>();
					curData.add(nums[i]);
					curData.add(nums[j]);
					curData.add(target - nums[i] - nums[j]);
					res.add(curData);
					while (j+1<nums.length && nums[j]==nums[j+1]){
						j++;
					}
				}
			}
			while (i+1<nums.length && nums[i]==nums[i+1]) i++;
		}
		return res;
	}
	public static void main(String[] args) {
//		int a[]={2,5,8,-6,9,7,-2};
//		int a[]={-1,0,1,2,-1,-4};
//		int a[]={0,0,0,0};
		int a[]={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}; //6
		threeSum(a);
	}
}
