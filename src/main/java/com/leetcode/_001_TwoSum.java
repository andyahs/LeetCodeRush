package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//

public class _001_TwoSum {


	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		int a[] = {3,2,4,11};
		int sum = 6;
		HashMap<Integer, Integer> x = new HashMap<Integer, Integer>();
		int []result = twoSum(a,sum);
		System.out.println(result[0]+"   "+result[1]);
//solution2

	}
}
