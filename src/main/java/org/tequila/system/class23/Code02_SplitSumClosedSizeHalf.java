package org.tequila.system.class23;

import org.junit.Test;

/**
 * @ClassName Code02_SplitSumClosedSizeHalf
 * @Description TODO
 * @Author GT-R
 * @Date 2023/11/2412:58
 * @Version 1.0
 */
public class Code02_SplitSumClosedSizeHalf {
    public int right(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int N = arr.length;
        if ((N & 1) == 0) {
            return process(arr, 0, N >> 1, sum >> 1);
        } else {
            return Math.max(process(arr, 0, N >> 1, sum >> 1), process(arr, 0, (N >> 1) + 1, sum >> 1));
        }
    }

    public int process(int[] arr, int index, int picks, int rest) {
        if (arr.length == index) {
            return picks == 0 ? 0 : -1;
        } else {
            int p1 = process(arr, index + 1, picks, rest);
            int next = -1, p2 = -1;
            if (arr[index] <= rest) {
                next = process(arr, index + 1, picks - 1, rest - arr[index]);
            }
            if (next != -1) {
                p2 = arr[index] + next;
            }
            return Math.max(p1, p2);
        }
    }

    public int dp(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        sum /= 2;
        int N = arr.length;
        int M = (N + 1) / 2;
        int[][][] dp = new int[N + 1][M + 1][sum + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= sum; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        for (int rest = 0; rest <= sum; rest++) {
            dp[N][0][rest] = 0;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int picks = 0; picks <= M; picks++) {
                for (int rest = 0; rest <= sum; rest++) {
                    int p1 = dp[i + 1][picks][rest];
                    // 就是要使用arr[i]这个数
                    int p2 = -1;
                    int next = -1;
                    if (picks - 1 >= 0 && arr[i] <= rest) {
                        next = dp[i + 1][picks - 1][rest - arr[i]];
                    }
                    if (next != -1) {
                        p2 = arr[i] + next;
                    }
                    dp[i][picks][rest] = Math.max(p1, p2);
                }
            }
        }
        if ((arr.length & 1) == 0) {
            return dp[0][arr.length / 2][sum];
        } else {
            return Math.max(dp[0][arr.length / 2][sum], dp[0][(arr.length / 2) + 1][sum]);
        }
    }

    @Test
    // for test
    public void testRight() {
        int maxLen = 10;
        int maxValue = 50;
        int testTime = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * maxLen);
            int[] arr = randomArray(len, maxValue);
            int ans1 = right(arr);
            int ans2 = dp(arr);
            if (ans1 != ans2) {
                printArray(arr);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }

    // for test
    public int[] randomArray(int len, int value) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * value);
        }
        return arr;
    }

    // for test
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
