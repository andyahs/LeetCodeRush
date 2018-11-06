package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/27 23:29
 * coding For love and Peace
 * 240搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *     每行的元素从左到右升序排列。
 *     每列的元素从上到下升序排列。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class _240_Searcha2DMatrixII {

    //换个方向测试
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0|| matrix[0] == null || matrix[0].length == 0) return false;
        int row = 0, col =matrix[0].length-1;
        while (true){
            if (matrix[row][col] >target) col--;
            else if (matrix[row][col]<target) row++;
            else return true;
            if (row >matrix.length-1||col <0 ) break;
        }

        return false;
    }

    //原答案
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0|| matrix[0] == null || matrix[0].length == 0) return false;
////        if (target < matrix[0][0] || target > matrix[matrix[0].length-1][matrix.length-1]) return false;
//        int x = matrix.length - 1, y = 0;
//        while (true) {
//            if (matrix[x][y] > target) --x;
//            else if (matrix[x][y] < target) ++y;
//            else return true;
//            if (x < 0 || y >= matrix[0].length) break;
//        }
//        return false;
//    }
}
