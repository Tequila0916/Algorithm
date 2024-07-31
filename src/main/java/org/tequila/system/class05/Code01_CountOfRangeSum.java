package org.tequila.system.class05;

/**
 * @ClassName Code01_CountOfRangeSum
 * @Description https://leetcode.cn/problems/count-of-range-sum/
 * @Author GT-R
 * @Date 2023/7/2609:09
 * @Version 1.0
 */
public class Code01_CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        long[] preSum = new long[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        return process(preSum, 0, preSum.length - 1, lower, upper);
    }

    public int process(long[] preSum, int L, int R, int lower, int upper) {
        if (L == R) {
            return preSum[L] >= lower && preSum[R] <= upper ? 1 : 0;
        }
        int M = L + ((R - L) >> 1);
        return process(preSum, L, M, lower, upper) + process(preSum, M + 1, R, lower, upper) + merge(preSum, L, M, R, lower, upper);
    }

    public int merge(long[] preSum, int l, int m, int r, int lower, int upper) {
        int ans = 0;
        int a = l;
        int s = l;
        for (int i = m + 1; i <= r; i++) {
            long min = preSum[i] - upper;
            long max = preSum[i] - lower;
            while (a <= m && preSum[a] < min) {
                a++;
            }
            while (s <= m && preSum[s] <= max) {
                s++;
            }
            ans += s - a;

        }
        long[] help = new long[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[index++] = preSum[p1] <= preSum[p2] ? preSum[p1++] : preSum[p2++];
        }
        while (p1 <= m) {
            help[index++] = preSum[p1++];
        }
        while (p2 <= r) {
            help[index++] = preSum[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            preSum[l + i] = help[i];
        }
        return ans;
    }


}
