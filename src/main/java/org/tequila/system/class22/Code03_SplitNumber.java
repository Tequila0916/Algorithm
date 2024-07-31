package org.tequila.system.class22;

import org.junit.Test;

/**
 * @ClassName Code03_SplitNumber
 * @Description TODO
 * @Author GT-R
 * @Date 2023/11/2313:22
 * @Version 1.0
 */
public class Code03_SplitNumber {
    public int ways(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return process(1, n);
    }

    public int process(int pre, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (pre > rest) {
            return 0;
        }
        int ways = 0;
        for (int first = pre; first <= rest; first++) {
            ways += process(first, rest - first);
        }
        return ways;
    }

    public int dp(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int pre = 1; pre <= n; pre++) {
            dp[pre][0] = 1;
            dp[pre][pre] = 1;
        }
        for (int pre = n - 1; pre > 1; pre--) {
            for (int rest = pre + 1; rest <= n; rest++) {
                dp[pre][rest] = dp[pre + 1][rest];
                dp[pre][rest] += dp[pre][rest - pre];
            }
        }
        return dp[1][n];
    }

    @Test
    public void testWays() {
        int times = 30;
        for (int i = 0; i < times; i++) {
            int n = (int) (Math.random() * times) + 1;
            if (dp(n) != ways(n)) {
                System.out.println("Error");
            }

        }
        System.out.println("finish");
    }
}
