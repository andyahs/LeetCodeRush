package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/14 23:29
 * coding For love and Peace
 */
public class _200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0
                || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                // 注意char
                if (grid[i][j] == '1') {
                    count++;
                    dfsSearch(grid, i, j, rows, cols);
                }
        return count++;
    }

    // 每遇到'1'后, 开始向四个方向 递归搜索. 搜到后变为'0',
    // 因为相邻的属于一个island. 然后开始继续找下一个'1'.
    private void dfsSearch(char[][] grid,
                           int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols)
            return;
        if (grid[i][j] != '1')
            return;
        // 也可以才用一个visited数组，标记遍历过的岛屿
        grid[i][j] = '0';
        dfsSearch(grid, i + 1, j, rows, cols);
        dfsSearch(grid, i - 1, j, rows, cols);
        dfsSearch(grid, i, j + 1, rows, cols);
        dfsSearch(grid, i, j - 1, rows, cols);

    }
    //  leetcode提供
    //    public int numIslands(char[][] grid) {
    //        if (grid == null || grid.length < 1 || grid[0].length < 1){
    //            return 0;
    //        }
    //         //这里做了一圈海洋？
    //        int[][] m = new int[grid.length][grid[0].length];
    //        for (int i = 0; i < m.length; i++) {
    //            for (int j = 0; j < m[0].length; j++) {
    //                if (grid[i][j] == '1'){
    //                    m[i][j] = 1;
    //                }else{
    //                    m[i][j] = 0;
    //                }
    //            }
    //        }
    //
    //        int num = 2;
    //        for (int i = 0; i < m.length; i++) {
    //            for (int j = 0; j < m[0].length; j++) {
    //                if (m[i][j] == 1){
    //                    depth(m, i, j, num);
    //                    num++;
    //                }
    //            }
    //        }
    //
    //        return num-2;
    //    }
    //
    //    public static void depth(int[][] m, int x, int y, int k){
    //       if (x<0 || x >= m.length || y<0 || y>=m[0].length){
    //           return;
    //       }
    //
    //       if (m[x][y] == 1){
    //           m[x][y] = k;
    //           depth(m, x+1, y, k);
    //           depth(m, x-1, y, k);
    //           depth(m, x, y+1, k);
    //           depth(m, x, y-1, k);
    //       }
    //
    //    }
}
