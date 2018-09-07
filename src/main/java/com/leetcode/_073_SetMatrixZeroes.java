package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/7 9:52
 * coding For love and Peace
 *
 * 题中使用O(mn) 的方案是新建矩阵
 * 使用 O(m + n) 的额外空间是新建一个行一个列数组，来表示最后是否要置零
 * 使用常数的额外空间,是利用了首行首列作否 置零的存储标识，然后设置两个布尔来判断是否最后要置零首行首列
 */

public class _073_SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        //首行首列作存储，另外设置两个布尔判断，最后是否要将首行首列置零
        boolean fRow = false,fCol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                    if (i==0) fRow =true;
                    if (j==0) fCol =true;
                }
            }
        }
        //设置成0
        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[0].length;j++){
                if (matrix[0][j]==0 ||matrix[i][0]==0) matrix[i][j] = 0;
            }
        }
        if (fRow){
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] =0;
            }
        }
        if (fCol){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] =0;
            }
        }

    }

    public static void main(String[] args) {
        int[][]matrix ={
                {1,2,3},
                {0,5,6},
                {3,2,1},
                {7,2,0}
        };
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("  "+matrix[i][j]+"  ");
            }
            System.out.println(" ");
        }
    }

}
