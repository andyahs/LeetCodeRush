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
		//最速方法如下 一言难尽...
		//      if (nums.length < 3)
		//        return Collections.emptyList();
		//      List<List<Integer>> res = new ArrayList<>();
		//      int minValue = Integer.MAX_VALUE;
		//      int maxValue = Integer.MIN_VALUE;
		//      int negSize = 0;
		//      int posSize = 0;
		//      int zeroSize = 0;
		//      for (int v : nums) {
		//        if (v < minValue)
		//          minValue = v;
		//        if (v > maxValue)
		//          maxValue = v;
		//        if (v > 0)
		//          posSize++;
		//        else if (v < 0)
		//          negSize++;
		//        else
		//          zeroSize++;
		//      }
		//      if (zeroSize >= 3)
		//        res.add(Arrays.asList(0, 0, 0));
		//      if (negSize == 0 || posSize == 0)
		//        return res;
		//      if (minValue * 2 + maxValue > 0)
		//        maxValue = -minValue * 2;
		//      else if (maxValue * 2 + minValue < 0)
		//        minValue = -maxValue * 2;
		//
		//      int[] map = new int[maxValue - minValue + 1];
		//      int[] negs = new int[negSize];
		//      int[] poses = new int[posSize];
		//      negSize = 0;
		//      posSize = 0;
		//      for (int v : nums) {
		//        if (v >= minValue && v <= maxValue) {
		//          if (map[v - minValue]++ == 0) {
		//            if (v > 0)
		//              poses[posSize++] = v;
		//            else if (v < 0)
		//              negs[negSize++] = v;
		//          }
		//        }
		//      }
		//      Arrays.sort(poses, 0, posSize);
		//      Arrays.sort(negs, 0, negSize);
		//      int basej = 0;
		//      for (int i = negSize - 1; i >= 0; i--) {
		//        int nv = negs[i];
		//        int minp = (-nv) >>> 1;
		//        while (basej < posSize && poses[basej] < minp)
		//          basej++;
		//        for (int j = basej; j < posSize; j++) {
		//          int pv = poses[j];
		//          int cv = 0 - nv - pv;
		//          if (cv >= nv && cv <= pv) {
		//            if (cv == nv) {
		//              if (map[nv - minValue] > 1)
		//                res.add(Arrays.asList(nv, nv, pv));
		//            } else if (cv == pv) {
		//              if (map[pv - minValue] > 1)
		//                res.add(Arrays.asList(nv, pv, pv));
		//            } else {
		//              if (map[cv - minValue] > 0)
		//                res.add(Arrays.asList(nv, cv, pv));
		//            }
		//          } else if (cv < nv)
		//            break;
		//        }
		//      }
		//      return res;
	}
	public static void main(String[] args) {
//		int a[]={2,5,8,-6,9,7,-2};
//		int a[]={-1,0,1,2,-1,-4};
//		int a[]={0,0,0,0};
		int a[]={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}; //6
		threeSum(a);
	}
}
