package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/31 16:50
 * coding For love and Peace
 */
public class _121_BestTimetoBuyandSellStock {

    //买股票的最佳时机I
    public static int maxProfit(int[] prices){
        if ( null ==prices||prices.length<=1) return 0;
        int max=  0,left = 0,right = prices.length-2;
        int []profits = new int[prices.length-1];
        for (int i =0; i<= right; i++ ){
            profits[i] = prices[i+1] - prices[i];
        }
        while (left<=right){
            int curProfits = 0;
            for (int i = left; i <= right; i++) {
                curProfits += profits[i];
            }
            if (curProfits>max){
                max = curProfits;
            }
            left = left+1;
            for (int i = left; i < right ; i++) {
                if (profits[i] >=0){
                    left = i;
                    break;
                }
            }
//            for (int i = right; i>left ; i--){
//                if (profits[i-1] <=0){
//                    right = i-1;
//                    break;
//                }
//            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
