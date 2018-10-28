package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andiz
 * 2018/9/18 23:49
 * coding For love and Peace
 * 078子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class _078_Subsets {

    //recursive
    private void traceforward(int[] nums, List<List<Integer>> solution, ArrayList<Integer> sol, int i) {
        if (i >= nums.length-1)
            return;
        for (int j = i+1; j < nums.length; j++) {
            ArrayList<Integer> solplus = new ArrayList<Integer>(sol); //复制一个数组 而不是alinating的方法
            solplus.add(nums[j]);
            solution.add(solplus);
            traceforward(nums, solution, solplus, j);
        }


    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        solution.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> sol = new ArrayList<Integer>();
            sol.add(nums[i]);
            solution.add(sol);
            traceforward(nums, solution, sol, i);
        }
        return solution;

    }
    //LeetCode提供
    //    List<List<Integer>> list = new ArrayList<>();
    //    public List<List<Integer>> subsets(int[] nums) {
    //        dfs(nums,0,"");
    //        return list;
    //    }
    //    List<Integer> l = new ArrayList<>();
    //    public void dfs(int[] nums,int n,String s){
    //        if(n == nums.length){
    //            list.add(new ArrayList(l));
    //            return;
    //        }
    //        dfs(nums,n+1,s);
    //        l.add(nums[n]);
    //        dfs(nums,n+1,s);
    //        l.remove(l.size()-1);
    //
    //    }

}
