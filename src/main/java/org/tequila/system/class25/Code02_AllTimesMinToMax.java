package org.tequila.system.class25;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName Code02_AllTimesMinToMax
 * @Description https://leetcode.cn/problems/maximum-subarray-min-product/
 * @Author GT-R
 * @Date 2023/12/210:11
 * @Version 1.0
 */
public class Code02_AllTimesMinToMax {


    public int max1(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int minNum = Integer.MAX_VALUE;
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    minNum = Math.min(minNum, arr[k]);
                }
                max = Math.max(max, minNum * sum);
            }
        }
        return max;
    }

    public int max2(int[] arr) {
        int N = arr.length;
        int[] sum = new int[N];
        sum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int l = stack.pop();
                max = Math.max(max, (stack.isEmpty() ? sum[i - 1] : (sum[i - 1] - sum[stack.peek()])) * arr[l]);

            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int l = stack.pop();
            max = Math.max(max, (stack.isEmpty() ? sum[N - 1] : (sum[N - 1] - sum[stack.peek()])) * arr[l]);
        }
        return max;
    }

    public int[] gerenareRondomArray() {
        int[] arr = new int[(int) (Math.random() * 20) + 10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
        return arr;
    }

    @Test
    public void testMax() {
        int testTimes = 2000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = gerenareRondomArray();
            if (max1(arr) != max2(arr)) {
                System.out.println("FUCK!");
                break;
            }
        }
        System.out.println("test finish");
    }
}
