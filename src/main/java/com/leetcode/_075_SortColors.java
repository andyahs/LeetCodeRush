package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/20 23:46
 * coding For love and Peace
 * 075颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *     一个直观的解决方案是使用计数排序的两趟扫描算法。
 *     首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 *     你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class _075_SortColors {

    //只用O(n)的算法，就是调换位置，这是基于只有三种颜色
    //所以可以0放在首部和2放在尾部进行遍历
    public static void sortColors(int[] nums) {
        int left=0,right = nums.length-1,cur = 0;
        int temp =0;
        while (cur<=right){
            switch (nums[cur]){
                case 0: temp = nums[cur];
                        nums[cur] = nums[left];
                        nums[left] = temp;
                        cur++;
                        left++;
                        break;
                case 1: cur++;
                        break;
                case 2: temp = nums[cur];
                        nums[cur] = nums[right];
                        nums[right] = temp;
                        right--;
                        break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        sortColors(nums);
    }

    //暴力计算
//    public void sortColors(int[] nums) {
//        if(null ==nums ||nums.length<=1) return;
//        int[] count =new int[3];
//        int index =0;
//        for (int i=0;i<nums.length ;i++) count[nums[i]]++;
//        for (int i=0;i< nums.length;i++){
//            if (i <count[0]) {
//                nums[i]=0;
//            }else if(i>=count[0] &&i <count[0]+count[1]){
//                nums[i] =1;
//            }else{
//                nums[i] = 2;
//            }
//        }
//
//    }
    //leetCode提供的解法
    //    public void sortColors(int[] nums) {
    //            int st=0,end=nums.length-1,cur=0;
    //            while(cur<=end){
    //                int temp = 0;
    //                switch(nums[cur]){
    //                    case 0:
    //                        temp = nums[st];
    //                        nums[st] = nums[cur];
    //                        nums[cur] = temp;
    //                        st++;
    //                        cur++;
    //                        break;
    //                    case 1:
    //                        cur++;
    //                        break;
    //                    case 2:
    //                        temp = nums[end];
    //                        nums[end] = nums[cur] ;
    //                        nums[cur] = temp;
    //                        end--;
    //                        break;
    //                }
    //            }
    //        }
}
