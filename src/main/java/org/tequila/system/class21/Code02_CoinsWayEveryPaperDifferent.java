package org.tequila.system.class21;

import org.junit.Test;

/**
 * @ClassName Code02_CoinsWayEveryPaperDifferent
 * @Description TODO
 * @Author GT-R
 * @Date 2023/11/1315:48
 * @Version 1.0
 */
public class Code02_CoinsWayEveryPaperDifferent {
    public int coinWays(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    public int process(int[] arr, int index, int rest) {
        if (rest < 0) {
            return 0;
        }
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        } else {
            return process(arr, index + 1, rest) + process(arr, index + 1, rest - arr[index]);
        }
    }

    public  int dp(int[] arr, int aim) {
        if(aim==0){
            return 1;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest] + (rest - arr[index] >= 0 ? dp[index + 1][rest - arr[index]] : 0);
            }
        }
        Utils.printMatrix(dp);
        return dp[0][aim];
    }
}
