package org.tequila.system.class41;

/**
 * @ClassName Code03_SplitArrayLargestSum
 * @Description https://leetcode.cn/problems/split-array-largest-sum/description/
 * @Author GT-R
 * @Date 2024/2/1821:10
 * @Version 1.0
 */
public class Code03_SplitArrayLargestSum {
    public int splitArray1(int[] nums, int k) {
        int N = nums.length;
        int[] sum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[][] dp = new int[N][k + 1];
        int[][] best = new int[N][k + 1];
        for (int j = 1; j <= k; j++) {
            dp[0][j] = nums[0];
            best[0][j] = -1;
        }
        for (int i = 1; i < N; i++) {
            dp[i][1] = sum(sum, 0, i);
            best[i][1] = -1;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = N - 1; i >= 1; i--) {
                int down = best[i][j - 1];
                int up = i == N - 1 ? N - 1 : best[i + 1][j];
                int ans = Integer.MAX_VALUE;
                int choose = -1;
                for (int leftEnd = down; leftEnd <= up; leftEnd++) {
                    int left = leftEnd == -1 ? 0 : dp[leftEnd][j - 1];
                    int right = leftEnd == i ? 0 : sum(sum, leftEnd + 1, i);
                    int cur = Math.max(left, right);
                    if (cur < ans) {
                        ans = cur;
                        choose = leftEnd;
                    }
                }
                dp[i][j] = ans;
                best[i][j] = choose;
            }
        }
        return dp[N - 1][k];

    }

    public int sum(int[] sum, int L, int R) {
        return sum[R + 1] - sum[L];
    }

    public int splitArray(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long l = 0;
        long r = sum;
        long ans = 0;
        while (l <= r) {
            long mid = l + ((r - l) >> 1);
            long cur = getNeedParts(nums, mid);
            if (cur <= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ans;
    }

    private long getNeedParts(int[] nums, long mid) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                return Integer.MAX_VALUE;
            }
        }
        int part = 1;
        int all = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (all + nums[i] > mid) {
                part++;
                all = nums[i];
            } else {
                all += nums[i];
            }
        }
        return part;
    }

}
