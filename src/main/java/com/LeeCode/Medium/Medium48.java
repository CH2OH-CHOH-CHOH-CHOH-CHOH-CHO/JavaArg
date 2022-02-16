package com.LeeCode.Medium;
/*给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

        你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

         

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/rotate-image
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium48 {

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int j =0;j<len/2;j++) {
            for (int i = j; i < len - 1 - j; i++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[len - 1 - i][j];
                matrix[len - 1- i][j] = matrix[len - 1 - j][len - 1- i];
                matrix[len - 1 - j][len - 1- i] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
    }
}
