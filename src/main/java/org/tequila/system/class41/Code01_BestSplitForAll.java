package org.tequila.system.class41;

import org.junit.Test;

/**
 * @ClassName Code01_BestSplitForAll
 * @Description TODO
 * @Author GT-R
 * @Date 2024/2/1417:42
 * @Version 1.0
 */
public class Code01_BestSplitForAll {
    public int bestSplit1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int ans = 0;
        int N = arr.length;
        for (int s = 0; s < N - 1; s++) {
            int sumL = 0;
            for (int i = 0; i <= s; i++) {
                sumL+=arr[i];
            }
            int sumR = 0;
            for (int i = s+1; i < N; i++) {
                sumR += arr[i];
            }
            ans = Math.max(ans,Math.min(sumL,sumR));
        }
        return ans;
    }

    public int bestSplit2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int N = arr.length;
        int sumAll = 0;
        for (int num : arr) {
            sumAll += num;
        }
        int ans = 0;
        int sumL = 0;
        // [0...s]  [s+1...N-1]
        for (int s = 0; s < N - 1; s++) {
            sumL += arr[s];
            int sumR = sumAll - sumL;
            ans = Math.max(ans, Math.min(sumL, sumR));
        }
        return ans;
    }

    public int[] randomArray(int len, int max) {
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        return ans;
    }

    @Test
    public void test() {
        int N = 20;
        int max = 30;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * N);
            int[] arr = randomArray(len, max);
            int ans1 = bestSplit1(arr);
            int ans2 = bestSplit2(arr);
            if (ans1 != ans2) {
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束");
    }
}
