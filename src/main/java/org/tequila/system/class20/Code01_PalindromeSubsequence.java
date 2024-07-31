package org.tequila.system.class20;

/**
 * @ClassName Code01_PalindromeSubsequence
 * @Description https://leetcode.cn/problems/longest-palindromic-subsequence/
 * @Author GT-R
 * @Date 2023/9/215:27
 * @Version 1.0
 */
public class Code01_PalindromeSubsequence {
    public int lpsl1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        return f(str, 0, N - 1);
    }

    public int f(char[] str, int L, int R) {
        if (L == R) {
            return 1;
        }
        if (L == R - 1) {
            return str[L] == str[R] ? 2 : 1;
        }
        int p1 = f(str, L + 1, R - 1);
        int p2 = f(str, L, R - 1);
        int p3 = f(str, L + 1, R);
        int p4 = str[L] == str[R] ? (2 + f(str, L + 1, R - 1)) : 0;
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    public int lpsl2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        dp[N - 1][N - 1] = 1;
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
        }
        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {
                dp[L][R] = Math.max(dp[L][R-1],dp[L+1][R]);
                if(str[L]==str[R]){
                    dp[L][R] = Math.max(dp[L][R],2+dp[L+1][R-1]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
