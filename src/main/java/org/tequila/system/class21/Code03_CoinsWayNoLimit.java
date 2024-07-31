package org.tequila.system.class21;

import org.junit.Test;

/**
 * @ClassName Code03_CoinsWayNoLimit
 * @Description TODO
 * @Author GT-R
 * @Date 2023/11/1317:31
 * @Version 1.0
 */
public class Code03_CoinsWayNoLimit {
    public int coinsWay(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    public int process(int[] arr, int index, int rest) {
        if (index == arr.length) { // 没钱了
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process(arr, index + 1, rest - (arr[index] * zhang));
        }
        return ways;
    }

    public int dp1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    ways += dp[index + 1][rest - (zhang * arr[index])];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    public int dp2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index+1][rest];
                if(rest-arr[index]>=0){
                    dp[index][rest] += dp[index][rest-arr[index]];
                }

            }
        }
        return dp[0][aim];
    }

    @Test
    public void testCoinsWay(){
        int[] arr = {1,2,5,10};
        int aim = 1000;
        int i = dp1(arr, aim);
        System.out.println(i);
        int i1 = dp2(arr, aim);
        System.out.println(i1);
    }

}
