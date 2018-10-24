package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/14 23:29
 * coding For love and Peace
 * 200岛屿的个数
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */
public class _200_NumberOfIslands {
    public static int numIslands(char[][] grid) {
        if (null ==grid || grid.length<=0 ||grid[0].length <=0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] =='1'){
                    count++;
                    dfsSearch(grid,i,j);
                }
            }
        }
        return count;
    }

    private static void dfsSearch(char[][] grid,int x,int y){
        grid[x][y] ='2';//为什么要向左和向上，因为那样再次传递后我们需要传参来表示从哪个方向来的
        //向上
        if (x-1 >= 0 &&grid[x-1][y] =='1') dfsSearch(grid,x-1,y);
        //向右
        if (y+1 < grid[0].length &&grid[x][y+1] =='1') dfsSearch(grid,x,y+1);
        //向左
        if (y-1 >= 0 &&grid[x][y-1] =='1') dfsSearch(grid,x,y-1);
        //向下
        if (x+1 <grid.length &&grid[x+1][y] =='1') dfsSearch(grid,x+1,y);
    }


    // 每遇到'1'后, 开始向四个方向 递归搜索. 搜到后变为'0',
    // 因为相邻的属于一个island. 然后开始继续找下一个'1'.

    //  leetcode提供
    //  public int numIslands(char[][] grid) {
    //        int m = grid.length;
    //        if(m == 0)
    //            return 0;
    //        int n = grid[0].length;
    //        int count = 0;
    //        for(int i = 0; i < m; i++){
    //            for(int j = 0; j < n; j++){
    //                if(grid[i][j] == '1'){
    //                    count++;
    //                    combine(grid, i, j);
    //                }
    //            }
    //        }
    //        return count;
    //    }
    //
    //
    //
    //    public static void combine(char[][] grid, int x, int y){
    //
    //        grid[x][y] = '2';
    //        if (x > grid.length-1 && y > grid[0].length-1 ) {
    //            return;
    //        }
    //        if (x < grid.length-1 && grid[x+1][y] == '1') {//向下
    //            combine(grid,x+1,y);
    //        }
    //        if (y < grid[0].length-1 && grid[x][y+1] == '1'){//向右
    //            combine(grid,x,y+1);
    //        }
    //        if (x > 0 && grid[x-1][y] == '1' ){//向上
    //            combine(grid,x-1,y);
    //        }
    //        if (y > 0 && grid[x][y-1] == '1') {//向左
    //            combine(grid,x,y-1);
    //        }
    //    }


    public static void main(String[] args) {
        char [][]grid = {
                {'1','1','1','1','0' },
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid));
    }
}
