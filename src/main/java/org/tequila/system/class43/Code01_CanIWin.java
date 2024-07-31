package org.tequila.system.class43;

/**
 * @ClassName Code01_CanIWin
 * @Description https://leetcode.cn/problems/can-i-win/
 * @Author GT-R
 * @Date 2024/2/2517:50
 * @Version 1.0
 */
public class Code01_CanIWin {
    public boolean canIWin1(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        if ((maxChoosableInteger * (1 + maxChoosableInteger) >> 1) < desiredTotal) {
            return false;
        }
        int[] arr = new int[maxChoosableInteger];
        for (int i = 0; i < maxChoosableInteger; i++) {
            arr[i] = i + 1;
        }
        return process1(arr, desiredTotal);
    }

    public boolean process1(int[] arr, int rest) {
        if (rest <= 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                int cur = arr[i];
                arr[i] = -1;
                boolean res = process1(arr, rest - cur);
                arr[i] = cur;
                if (!res) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        if ((maxChoosableInteger * ((maxChoosableInteger + 1) >> 1)) < desiredTotal) {
            return false;
        }
        return process2(maxChoosableInteger, 0, desiredTotal);
    }

    public boolean process2(int choose, int status, int rest) {
        if (rest <= 0) {
            return false;
        }
        for (int i = 1; i <= choose; i++) {
            if ((status & (1 << i)) == 0) {
                if (!process2(choose, status | (1 << i), rest - i)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        if ((maxChoosableInteger * (maxChoosableInteger + 1) >> 1) < desiredTotal) {
            return false;
        }
        int[] dp = new int[1 << (maxChoosableInteger + 1)];
        return process(maxChoosableInteger, 0, desiredTotal, dp);
    }

    public boolean process(int choose, int status, int rest, int[] dp) {
        if (dp[status] != 0) {
            return dp[status] == 1;
        }
        boolean ans = false;
        if (rest > 0) {
            for (int i = 1; i <= choose; i++) {
                if(((1<<i)&status)==0){
                    if (!process(choose, (status | (1 << i)), rest - i, dp)) {
                        ans = true;
                        break;
                    }
                }
            }
        }
        dp[status] = ans ? 1 : -1;
        return ans;
    }

}
