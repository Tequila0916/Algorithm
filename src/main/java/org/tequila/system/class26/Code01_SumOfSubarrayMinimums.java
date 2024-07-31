package org.tequila.system.class26;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName Code01_SumOfSubarrayMinimums
 * @Description https://leetcode.cn/problems/sum-of-subarray-minimums/
 * @Author GT-R
 * @Date 2023/12/309:09
 * @Version 1.0
 */
public class Code01_SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int[] left = nearLessEqualLeft(arr);
        int[] right = nearLessRight(arr);
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            long start = i - left[i];
            long end = right[i] - i;
            ans += start * end * (long) arr[i];
            ans %= 1000000007;
        }
        return (int) ans;
    }

    public int[] nearLessEqualLeft(int[] arr) {
        int N = arr.length;
        int[] left = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            left[stack.pop()] = -1;
        }
        return left;

    }

    public int[] nearLessRight(int[] arr) {
        int N = arr.length;
        int[] right = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            right[stack.pop()] = N;
        }
        return right;

    }
}
