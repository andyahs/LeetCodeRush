package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andiz
 * 2018/8/21 9:38
 * coding For love and Peace
 */
//有效的数独
public class _036_ValidSudoku {
    //1、我最初的写法 需要分别检测行列块
    public static boolean isValidSudoku(char[][] board){
//        if (null == board ||board.length !=9 ||board[0].length !=9) return false;
//        Set<Character> blockSet = new HashSet<Character>();
//        Set<Character> rowSet = new HashSet<Character>();
//        Set<Character> colSet = new HashSet<Character>();
//        for (int i=0; i<9 ;i++){
//            rowSet.clear();
//            colSet.clear();
//            for (int j=0; j<9 ; j++){
//                if ('.' !=board[i][j] ){
//                    if (rowSet.contains(board[i][j])){
//                        return false;
//                    }else {
//                        rowSet.add(board[i][j]);
//                    }
//                }
//                if ('.' != board[j][i]){
//                    if (colSet.contains(board[j][i])){
//                        return false;
//                    }else {
//                        colSet.add(board[j][i]);
//                    }
//                }
//            }
//        }
//        //检测块
//        for (int rowst=0;rowst<9 ;rowst+=3){
//            for (int colst =0; colst<9; colst+=3){
//                blockSet.clear();
//                for (int i = rowst ; i<rowst+3 ; i++){
//                    for (int j =colst ; j<colst+3; j++){
//
//                        if ('.' != board[i][j]){
//                            if (blockSet.contains(board[i][j])){
//                                return false;
//                            }else {
//                                blockSet.add(board[i][j]);
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
//        return true;
    //2上面是我的原来暴力解法 40% 33ms 以下是leetCode提供的高效算法
    //减少了占用空间 例如signs[0][i]内涵整行，可以与n做与运算，不为0 则说明已有这个值
//    int[][] signs = new int[3][9];
//        for (int i = 0; i < 9; i++) {
//        for (int j = 0; j < 9; j++) {
//            if (board[i][j] == '.')
//                continue;
//            int n = 1 << (board[i][j] - '1');
//            int cubeIndex = i / 3 * 3 + j / 3;
//            if ((signs[0][i] & n) != 0 || (signs[1][j] & n) != 0 || (signs[2][cubeIndex] & n) != 0)
//                return false;
//            signs[0][i] |= n;
//            signs[1][j] |= n;
//            signs[2][cubeIndex] |= n;
//        }
//    }

        //3、尝试一种新的解法
        boolean[][] rowArr = new boolean[9][9];
        boolean[][] colArr = new boolean[9][9];
        boolean[][] blockArr = new boolean[9][9];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int c = board[i][j] - '1';
                    if (rowArr[i][c] || colArr[c][j] || blockArr[3 * (i / 3) + j / 3][c]) return false;
                    rowArr[i][c] = true;
                    colArr[c][j] = true;
                    blockArr[3 * (i / 3) + j / 3][c] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board1 = {
                  {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                  {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                  {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                  {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                  {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                  {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                  {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                  {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                  {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        char[][] board2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board1));
        System.out.println(isValidSudoku(board2));
    }
}
