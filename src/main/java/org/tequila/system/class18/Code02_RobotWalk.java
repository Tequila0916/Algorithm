package org.tequila.system.class18;

import org.junit.Test;

/**
 * @ClassName Code02_RobotWalk
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2409:01
 * @Version 1.0
 */
public class Code02_RobotWalk {
    public int way(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        return process(N, start, aim, K, dp);

    }

    /**
     *
     * @param N     一共有哪些位置
     * @param cur   机器人当前来到的位置 1～N
     * @param aim   最终的目标
     * @param rest  还剩多少步 0～K
     * @param dp    缓存优化 初始化值为-1
     * @return
     */

    public int process(int N, int cur, int aim, int rest, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int ans = 0;
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process(N, 2, aim, rest - 1, dp);
        } else if (cur == N) {
            ans = process(N, N - 1, aim, rest - 1, dp);
        } else {
            ans = process(N, cur - 1, aim, rest - 1, dp) + process(N, cur + 1, aim, rest - 1, dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }

    public int way2(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }
        return dp[start][K];
    }

    @Test
    public void testWay() {
        int result = way2(5, 2, 4, 6);
        System.out.println("result = " + result);
    }
}
