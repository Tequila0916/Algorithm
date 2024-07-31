package org.tequila.system.class21;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @ClassName Code04_CoinsWaySameValueSamePapper
 * @Description TODO
 * @Author GT-R
 * @Date 2023/11/1410:13
 * @Version 1.0
 */
public class Code04_CoinsWaySameValueSamePapper {
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

    public int coinsWay(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        Info info = getInfo(arr);
        return process(info.coins, info.zhangs, 0, aim);
    }

    /**
     *
     * @param coins 面值数组 且去重
     * @param zhangs    每种面值对应的张数
     * @param index
     * @param rest
     * @return
     */
    private int process(int[] coins, int[] zhangs, int index, int rest) {
        if (index == coins.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * coins[index] <= rest && zhang <= zhangs[index]; zhang++) {
            ways += process(coins, zhangs, index + 1, rest - (zhang * coins[index]));
        }
        return ways;
    }

    public int dp1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        Info info = getInfo(arr);
        int[] coins = info.coins;
        int[] zhangs = info.zhangs;
        int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * coins[index] <= rest && zhang <= zhangs[index]; zhang++) {
                    ways += dp[index + 1][rest - (zhang * coins[index])];
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
        Info info = getInfo(arr);
        int[] coins = info.coins;
        int[] zhangs = info.zhangs;
        int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
               dp[index][rest] = dp[index+1][rest];
               if(rest-coins[index]>=0){
                   dp[index][rest] += dp[index][rest-coins[index]];
               }
               if(rest-(zhangs[index]+1)*coins[index]>=0){
                   dp[index][rest] -= dp[index+1][rest-coins[index]*(zhangs[index]+1)];
               }
            }
        }
        return dp[0][aim];
    }

    @Test
    public void testCoinsWay() {
        int[] arr = {1, 2, 1, 1, 1, 5,10,100,10,10,10,10,10,10,10,10,10,10,20,2,2,1,1,1,1,5,5,5,5,5,2,2,2,2,5,5,5,5,5,5,1,1,1,2,2,2,4,4,4,4,6,6,6,2, 2, 1, 2};
       if(dp1(arr,100)!=dp2(arr,100)){
           System.out.println("ERROR");
       }
        System.out.println(dp1(arr,100));
        System.out.println("OK");
    }
}
