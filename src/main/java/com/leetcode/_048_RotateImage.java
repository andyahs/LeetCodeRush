package com.leetcode;

/**
 * Created by Andiz
 * 2018/8/21 15:25
 * coding For love and Peace
 */
public class _048_RotateImage {
//    旋转图形
    public static void rotate(int [][] matrix) {
        if (null ==matrix || 1>=matrix.length){

        }
        int n = matrix[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;

            }
        }
        for (int i =0 ; i<matrix.length ; i++){
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = 0;
                int right = matrix[0].length - 1 - j;
                if (j <= right) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][right];
                    matrix[i][right] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [][]matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        rotate(matrix);
        for (int i=0; i<3; i++){
            System.out.println(matrix[i][0]+" "+matrix[i][1]+" "+matrix[i][2]+" ");
        }
    }

}
