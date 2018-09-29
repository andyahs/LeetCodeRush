package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/29 23:03
 * coding For love and Peace
 * 062. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 */
public class _062_UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] arr=  new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
    //看了这位老哥的骚操作，大佬看出了这个算法其实是一个一维数组的多次遍历计算，
    // dp[j]在未进行运算前其实就是二维的arr[i][j-1];
    // 这tm就是降维做法啊
    //    public int uniquePaths(int m, int n) {
    //        int[] dp = new int[n];
    //        Arrays.fill(dp, 1);
    //        for (int i = 1; i < m; ++i) {
    //            for (int j = 1; j < n; ++j) {
    //                dp[j] += dp[j - 1];
    //            }
    //        }
    //        return dp[n - 1];
    //    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
}
