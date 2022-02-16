package com.LeeCode.Medium;
/*给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

        此外，你可以假设该网格的四条边均被水包围。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/number-of-islands
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
/*
* 深度优先搜索、广度优先搜索、并查集
* 注意：判断是否越界是i>0或i<lenth-1
*      二维数组的初始化代码
*
*
* */
public class Medium200 {
    public static void main(String[] args) {
        char[][] arr = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(new Medium200().numIslands(arr));
    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int nums=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]=='1') {
                    this.DFS(i,j,grid);
                    nums ++;
                }
            }
        }
        return nums;
    }

    private void DFS(int i,int j,char[][] grid){
        int row = grid.length-1;
        int column = grid[0].length-1;
        if(grid[i][j]=='1'){
            grid[i][j]='0';
            if(i>0) DFS(i-1,j,grid);
            if(j>0) DFS(i,j-1,grid);
            if(i<row) DFS(i+1,j,grid);
            if(j<column) DFS(i,j+1,grid);
        }
    }
}
