package com.LeeCode.Medium;
/*根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

        给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

        如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
        如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
        如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
        如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
        下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/game-of-life
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
/*
* 由于要求原地变换的方式，因此可以采用为数组采用额外标记的方式实现
*
*
*
* */
public class Medium289 {

    public void gameOfLife(int[][] board) {
        for(int i =0;i< board.length;i++){
            for(int j=0;j<board[0].length;j++){
                //由死变活
                if(board[i][j]==0) {
                    if(ofStatus(i,j,board)==3) board[i][j]=-1;
                }
                //由活变死
                else {
                    if(ofStatus(i,j,board)<2 || ofStatus(i,j,board)>3) board[i][j]=2;
                }
            }
        }
        for(int i =0;i< board.length;i++){
            for(int j=0;j<board[0].length;j++){
                //由死变活
                if(board[i][j]==-1) {
                    board[i][j]=1;
                }
                //由活变死
                else if(board[i][j]==2){
                    board[i][j]=0;
                }
            }
        }
    }

    private int ofStatus(int i,int j,int[][] a){
        int aliveNums=0;
        int m=a.length-1;
        int n=a[0].length-1;
        if(i!=0){
            aliveNums+=a[i-1][j]>0?1:0;
            if(j!=0) aliveNums+=a[i-1][j-1]>0?1:0;
        }
        if(j!=0){
            aliveNums+=a[i][j-1]>0?1:0;
            if(i!=m)  aliveNums+=a[i+1][j-1]>0?1:0;
        }
        if(i!=m) {
            aliveNums+=a[i+1][j];
            if(j!=n) aliveNums+=a[i+1][j+1]>0?1:0;
        }
        if(j!=n) {
            aliveNums+=a[i][j+1]>0?1:0;
            if(i!=0) aliveNums+=a[i-1][j+1]>0?1:0;
        }
        return aliveNums;
    }

}
