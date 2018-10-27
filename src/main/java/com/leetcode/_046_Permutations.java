package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andiz
 * 2018/9/17 0:19
 * coding For love and Peace
 * 046全排列
 *给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class _046_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (null ==nums ||nums.length <1) return res;
        boolean[] flags = new boolean[nums.length];

        List<Integer> curList = new LinkedList<>();
        permute(nums,flags,curList,res);
        return res;
    }
    public  static void permute(int[] nums,boolean[] flags, List<Integer>curList,List<List<Integer>> res){
        if (curList.size() ==nums.length) {
            res.add(new LinkedList<>(curList));
            return;
        }
        for (int i = 0;i<nums.length ; i++){
            if (!flags[i]) {
                curList.add(nums[i]);
                flags[i] =true;
                permute(nums,flags,curList,res);
                curList.remove(curList.size()-1);
                flags[i] = false;
            }
        }

    }

//    public static List<List<Integer>> permute(int[] num) {
//        List<List<Integer>> res=new ArrayList<>();
//        int len=num.length;
//        if(num==null||len==0){
//            return res;
//        }
//        boolean [] visit=new boolean [len];
//        ArrayList<Integer> list=new ArrayList<>();
//        dfs(num,list,visit,res);
//        return res;
//    }
//    public static void dfs(int [] num,ArrayList<Integer> list,boolean [] visit,List<List<Integer>> res){
//        if(list.size()==num.length){
//            res.add(new ArrayList<Integer>(list));
//            return ;
//        }
//        for(int i=0;i<num.length;i++){
//            if(!visit[i]){
//                visit[i]=true;
//                list.add(num[i]);
//                dfs(num,list,visit,res);
//                list.remove(list.size()-1);
//                visit[i]=false;
//            }
//        }
//    }

    // LeetCode提供
    //    public List<List<Integer>> permute(int[] nums) {
    //        List<List<Integer>> res = new ArrayList<List<Integer>>();
    //        ArrayList<Integer> temp = new ArrayList<Integer>();
    //        dfs(res, nums, 0);
    //        return res;
    //    }
    //    private void dfs(List<List<Integer>> res, int[] nums, int j) {
    //        if (j == nums.length) {
    //            List<Integer> temp = new ArrayList<Integer>();
    //            for (int num : nums) temp.add(num);
    //            res.add(temp);
    //        }
    //        for (int i = j; i < nums.length; i++) {
    //            swap(nums, i, j);
    //            dfs(res, nums, j+1);
    //            swap(nums, i, j);
    //        }
    //    }
    //    private void swap(int[] nums, int m, int n) {
    //        int temp = nums[m];
    //        nums[m] = nums[n];
    //        nums[n] = temp;
    //    }

    public static void main(String[] args) {
        int[] nums= {1,2,3};
        List<List<Integer>> res = permute(nums);
    }

}
