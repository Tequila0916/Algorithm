package org.tequila.system.class24;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @ClassName Code04_MinCoinsOnePaper
 * @Description TODO
 * @Author GT-R
 * @Date 2023/11/3023:03
 * @Version 1.0
 */
public class Code04_MinCoinsOnePaper {
    public int minCoins(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    public int process(int[] arr, int index, int rest) {
        if (rest < 0) {
            return Integer.MAX_VALUE;
        }
        if (index == arr.length) {
            return rest == 0 ? 0 : Integer.MAX_VALUE;
        } else {
            int p1 = process(arr, index + 1, rest);
            int p2 = process(arr, index + 1, rest - arr[index]);
            if (p2 != Integer.MAX_VALUE) {
                p2++;
            }
            return Math.min(p1, p2);
        }
    }

    public int dp1(int[] arr, int aim) {
        if (aim == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 0;
        for (int j = 1; j <= aim; j++) {
            dp[N][j] = Integer.MAX_VALUE;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = rest - arr[index] >= 0 ? dp[index + 1][rest - arr[index]] : Integer.MAX_VALUE;
                if (p2 != Integer.MAX_VALUE) {
                    p2++;
                }
                dp[index][rest] = Math.min(p1, p2);
            }
        }
        return dp[0][aim];
    }

    public int dp2(int[] arr, int aim) {
        if (aim == 0) {
            return 0;
        }
        Info info = getInfo(arr);
        int[] coins = info.coins;
        int[] zhangs = info.zhangs;
        int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 0;
        for (int j = 1; j <= aim; j++) {
            dp[N][j] = Integer.MAX_VALUE;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                for (int zhang = 1; zhang * coins[index] <= aim && zhang <= zhangs[index]; zhang++) {
                    if (rest - coins[index] * zhang >= 0 && dp[index + 1][rest - coins[index] * zhang] != Integer.MAX_VALUE) {
                        dp[index][rest] = Math.min(dp[index][rest], zhang + dp[index + 1][rest - coins[index] * zhang]);
                    }
                }
            }
        }
        return dp[0][aim];
    }

    @Test
    public void testMinCoins() {
        int maxLen = 20;
        int maxValue = 30;
        int testTime = 300000;
        System.out.println("功能测试开始");
        for (int i = 0; i < testTime; i++) {
            int N = (int) (Math.random() * maxLen);
            int[] arr = Utils.randomArray(N, maxValue);
            int aim = (int) (Math.random() * maxValue);
            int ans1 = dp2(arr, aim);
            int ans2 = dp1(arr, aim);
            if (ans1 != ans2) {
                System.out.println("Oops!");
                Utils.printArray(arr);
                System.out.println(aim);
                System.out.println(ans1);
                System.out.println(ans2);
                break;
            }
        }
        System.out.println("功能测试结束");
    }

    public Info getInfo(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int value : arr) {
            if (!counts.containsKey(value)) {
                counts.put(value, 1);
            } else {
                counts.put(value, counts.get(value) + 1);
            }
        }
        int N = counts.size();
        int[] coins = new int[N];
        int[] zhangs = new int[N];
        int index = 0;
        for (Entry<Integer, Integer> entry : counts.entrySet()) {
            coins[index] = entry.getKey();
            zhangs[index++] = entry.getValue();
        }
        return new Info(coins, zhangs);
    }
}
