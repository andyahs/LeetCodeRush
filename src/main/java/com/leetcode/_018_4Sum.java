package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class _018_4Sum {
	public static HashSet<int []> FourSum(int[] nums,int target){
		int [] res = new int [4];
		HashSet<int []> resp = new HashSet<int[]>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length-3; i++){
			for(int j=i+i; j<nums.length-2; j++){
				if( j>i+1 &&nums[j] == nums[j-1]) continue;
				int left= j+1,right = nums.length-1;
				while(left < right){
					int sum = nums[i]+nums[j]+nums[left]+nums[right];
					if(sum == target){
						int [] out = {nums[i],nums[j],nums[left],nums[right],};
						resp.add(out);
						++left;
						--right;
					}else if(sum <target){
						++left;
					}else --right;
				}
			}
		}
		
		return resp;
	}
	
	
	public static void main(String[] args) {
		int[] arr= {1,0,-1,0,-2,2};
		HashSet<int []> asw = FourSum(arr, 0);
		for(int[] sa:asw){
			for(int i=0;i<sa.length;i++){
				System.out.print(sa[i]+" ");
			}
			System.out.println();
		}
	}
	
}
