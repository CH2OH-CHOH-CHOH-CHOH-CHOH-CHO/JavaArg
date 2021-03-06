package com.LeeCode.Offer;

import java.util.HashSet;
import java.util.Set;

/*给定一个 m x n 二维字符网格 board 和一个字符串单词 arr 。如果 arr 存在于网格中，返回 true ；否则，返回 false 。

        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

         

        例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。



        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Offer12 {

    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();

        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(DFS(board, arr, i, j, 0)) return true;
            }
        }
        return false;

    }

    private boolean DFS(char[][] board, char[] arr, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != arr[k]) return false;
        if(k==arr.length-1) return true;
        board[i][j] = ' ';
        boolean res = DFS(board, arr, i + 1, j, k + 1) || DFS(board, arr, i - 1, j, k + 1) ||
                DFS(board, arr, i, j + 1, k + 1) || DFS(board, arr, i , j - 1, k + 1);
        board[i][j] = arr[k];
        return res;
    }
}
