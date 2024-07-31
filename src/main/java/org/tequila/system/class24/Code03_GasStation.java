package org.tequila.system.class24;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @ClassName Code03_GasStation
 * @Description https://leetcode.cn/problems/gas-station/
 * @Author GT-R
 * @Date 2023/11/3020:25
 * @Version 1.0
 */
public class Code03_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        boolean[] good = goodArray(gas, cost);
        for (int i = 0; i < gas.length; i++) {
            if (good[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean[] goodArray(int[] g, int[] c) {
        int N = g.length;
        int M = N << 1;
        int[] arr = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = g[i] - c[i];
            arr[i + N] = g[i] - c[i];
        }
        for (int i = 1; i < M; i++) {
            arr[i] += arr[i - 1];
        }
        LinkedList<Integer> w = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            while (!w.isEmpty() && arr[w.peekLast()] >= arr[i]) {
                w.pollLast();
            }
            w.addLast(i);
        }
        boolean[] ans = new boolean[N];
        for (int offset = 0, i = 0, j = N; j < M; offset = arr[i++], j++) {
            if (arr[w.peekFirst()] - offset >= 0) {
                ans[i] = true;
            }
            if(w.peekFirst()==i){
                w.pollFirst();
            }
            while (!w.isEmpty()&&arr[w.peekLast()]>=arr[j]){
                w.pollLast();
            }
            w.addLast(j);
        }
        return ans;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int N = gas.length;
        int M = N << 1;
        int[] arr = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = gas[i] - cost[i];
            arr[i + N] = gas[i] - cost[i];
        }
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < i + N; j++) {
                sum += arr[j];
                if (sum < 0) {
                    break;
                }
                if (j - i == N - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int maxLen = 10;
        int maxValue = 200;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int sum = (int) (Math.random() * (maxValue + 1));
            int[] gas = generateRandomArray(sum, maxValue);
            int[] cost = generateRandomArray(sum, maxValue);
            int ans1 = canCompleteCircuit(gas, cost);
            int ans2 = canCompleteCircuit1(gas, cost);
            if (ans1 != ans2) {
                System.out.println("Oops!");
                System.out.println(ans1);
                System.out.println(ans2);
                break;
            }
        }
        System.out.println("测试结束");

    }


    // for test
    public int[] generateRandomArray(int len, int maxValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    // for test
    public void printArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
