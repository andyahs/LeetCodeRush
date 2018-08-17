package com.leetcode.www;

import java.util.Arrays;
import java.util.HashMap;

//a+b+c = 0
//without sort, print the same answer
public class _015_3Sum {
	
	public static void find3Sum(int [] a){
		int target = 0;
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		HashMap<Integer, Integer> x = new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++){
			x.put(a[i], i);
		}
		for(int i = 0; i<a.length;i++){
			//if(x.get(target - a[i]) != null){
				for(int j = i+1 ; j<a.length-1 ; j++){
					if(x.get(target-a[i]-a[j])!= null){
						System.out.println(i+" "+a[i]+" "+j+" "+a[j]+" "+x.get(target-a[i]-a[j])+((target-a[i]-a[j])));
					}
			//	}
			}
		}
	}
	public static void main(String[] args) {
		int a[]={2,5,8,-6,9,7,-2};
		find3Sum(a);
	}
}
