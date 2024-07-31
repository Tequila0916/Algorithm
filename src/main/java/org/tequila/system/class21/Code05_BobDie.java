package org.tequila.system.class21;

import org.junit.Test;

/**
 * @ClassName Code05_BobDie
 * @Description TODO
 * @Author GT-R
 * @Date 2023/11/1512:38
 * @Version 1.0
 */
public class Code05_BobDie {
    public double livePosibility1(int row, int col, int k, int N, int M) {
        return (double) process(row, col, k, N, M) / Math.pow(4, k);
    }

    public long process(int row, int col, int k, int N, int M) {
        if (row < 0 || row == N || col < 0 || col == M) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        long north = process(row + 1, col, k - 1, N, M);
        long south = process(row - 1, col, k - 1, N, M);
        long west = process(row, col - 1, k - 1, N, M);
        long east = process(row, col + 1, k - 1, N, M);
        return north + south + west + east;
    }


    public  double livePosibility2(int row, int col, int k, int N, int M) {
        long[][][] dp = new long[N][M][k + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int rest = 1; rest <= k; rest++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    dp[r][c][rest] = pick(dp, N, M, r - 1, c, rest - 1);
                    dp[r][c][rest] += pick(dp, N, M, r + 1, c, rest - 1);
                    dp[r][c][rest] += pick(dp, N, M, r, c - 1, rest - 1);
                    dp[r][c][rest] += pick(dp, N, M, r, c + 1, rest - 1);
                }
            }
        }
        return (double) dp[row][col][k] / Math.pow(4, k);
    }

    public  long pick(long[][][] dp, int N, int M, int r, int c, int rest) {
        if (r < 0 || r == N || c < 0 || c == M) {
            return 0;
        }
        return dp[r][c][rest];
    }

    @Test
    public void testlivePosibility() {
        long start = System.currentTimeMillis();
        livePosibility2(6, 6, 10, 500, 500);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        start = System.currentTimeMillis();
        livePosibility1(6, 6, 10, 500, 500);
        end = System.currentTimeMillis();
        System.out.println(end-start);

    }

}
