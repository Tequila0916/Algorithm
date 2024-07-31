package org.tequila.system.class21;

import org.junit.Test;

/**
 * @ClassName Code01_MinPathSum
 * @Description TODO
 * @Author GT-R
 * @Date 2023/11/1211:28
 * @Version 1.0
 */
public class Code01_MinPathSum {
    public int minPathSum1(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row][col];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];

        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    @Test
    public void testMinPathSum() {
        int[][] matrix = Utils.generateRandomMatrix(4, 4);
        int i = minPathSum1(matrix);
        System.out.println(i);
        Utils.printMatrix(matrix);

    }
}
