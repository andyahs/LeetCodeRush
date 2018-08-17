package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/17 13:59
 * coding For love and Peace
 */
public class _122_BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        if (0 == size || null == prices) return 0;
        int max = 0;
        for(int i=1; i<size; i++) {
            if(prices[i] > prices[i-1] ) {
                max += (prices[i] - prices[i-1]);
            }
        }
        return max;
    }
}
