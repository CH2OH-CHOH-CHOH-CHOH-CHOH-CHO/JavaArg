package com.LeeCode.Medium;

/*二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。

        请返回 封闭岛屿 的数目。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/number-of-closed-islands
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium1254 {
    public int closedIsland(int[][] grid) {
        int res = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0 && recur(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    boolean recur(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return false;
        if (grid[r][c] != 0) return true;
        grid[r][c] = 2;
        boolean b1 = recur(grid, r + 1, c);
        boolean b2 = recur(grid, r - 1, c);
        boolean b3 = recur(grid, r, c - 1);
        boolean b4 = recur(grid, r, c + 1);
        return b1 && b2 && b3 && b4;//不能图方便将上述合并一起写，因为会无法遍历全部可能，导致新一轮条件判断时出现问题。
    }
}
