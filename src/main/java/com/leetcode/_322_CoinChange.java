package com.leetcode;

import java.util.Arrays;

/**
 * Created by Andiz
 * 2018/9/30 23:33
 * coding For love and Peace
 * 依然是动态规划
 * 322零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class _322_CoinChange {
    //这种方法当做跳格子，每一格子所需要最少步数。比如coin[] = {1,3,5}
    //amout =5 则dp[] = {1,2,1,2,1};
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int j = 0; j < coins.length; j++)
            for (int i = coins[j]; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        return dp[amount] > amount ? -1 : dp[amount];
    }
    //leetCode提供的算法
//    int total;
//    public int coinChange(int[] coins, int amount) {
//        total = Integer.MAX_VALUE;
//       if(amount == 0) return 0;
//       Arrays.sort(coins);
//       count(amount, coins.length-1, coins, 0);
//	   return total == Integer.MAX_VALUE?-1:total;
//
//
//    }
//    void count(int amount, int index, int[] coins, int count){
//        if(index < 0 || count >= total -1) return;
//        int c = amount/coins[index];
//        for(int i = c; i >=0; i--){
//            int newCount = count + i;
//            int rem = amount - i*coins[index];
//            if(rem > 0 && newCount<total)
//                count(rem, index - 1, coins, newCount);
//            else if(newCount<total)
//                total = newCount;
//            else if(newCount>=total-1)
//                break;
//        }
//
//    }
}
