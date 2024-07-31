package org.tequila.system.class42;

/**
 * @ClassName Code02_ThrowChessPiecesProblem
 * @Description https://leetcode.cn/problems/super-egg-drop/description/
 * @Author GT-R
 * @Date 2024/2/1914:15
 * @Version 1.0
 */
public class Code02_ThrowChessPiecesProblem {
    public int superEggDrop1(int k, int n) {
        if (k < 1 || n < 1) {
            return 0;
        }
        return process(n, k);
    }

    public int process(int rest, int k) {
        if (rest == 0) {
            return 0;
        }
        if (k == 1) {
            return rest;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= rest; i++) {
            min = Math.min(min, Math.max(process(i - 1, k - 1), process(rest - i, k)));
        }
        return min + 1;
    }

    public int superEggDrop2(int k, int n) {
        if (k < 1 || n < 1) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = i;
        }
        int[][] best = new int[n + 1][k + 1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[1][i] = 1;
            best[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = k; j > 1; j--) {
                int ans = Integer.MAX_VALUE;
                int bestChoose = -1;
                int down = best[i - 1][j];
                int up = j == k ? i : best[i][j + 1];
                for (int l = down; l <= up; l++) {
                    int cur = Math.max(dp[l - 1][j - 1], dp[i - l][j]);
                    if (cur < ans) {
                        ans = cur;
                        bestChoose = l;
                    }
                }
                dp[i][j] = ans + 1;
                best[i][j] = bestChoose;
            }
        }
        return dp[n][k];
    }

    public int superEggDrop(int k, int n) {
        if (k < 1 || n < 1) {
            return 0;
        }
        int[] dp = new int[k];
        int res = 0;
        while (true) {
            res++;
            int pre = 0;
            for (int i = 0; i < k; i++) {
                int temp = dp[i];
                dp[i] = dp[i] + pre + 1;
                pre = temp;
                if (dp[i] >= n) {
                    return res;
                }
            }
        }
    }
}
