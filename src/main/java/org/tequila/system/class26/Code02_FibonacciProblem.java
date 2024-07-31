package org.tequila.system.class26;

import org.junit.Test;

/**
 * @ClassName Code02_FibonacciProblem
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/316:11
 * @Version 1.0
 */
public class Code02_FibonacciProblem {
    public int f1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return f1(n - 2) + f1(n - 1);
    }

    public int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre = 1;
        int res = 1;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res = res + pre;
            pre = temp;

        }
        return res;
    }

    public int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    public int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] t = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = product(res, t);
            }
            t = product(t, t);
        }
        return res;
    }

    private int[][] product(int[][] a, int[][] b) {
        int n = a.length;
        int m = b[0].length;
        int k = a[0].length; // a的列数同时也是b的行数
        int[][] ans = new int[n][m];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < m;j++) {
                for(int c = 0; c < k; c++) {
                    ans[i][j] += a[i][c] * b[c][j];
                }
            }
        }
        return ans;
    }


    @Test
    public void testFibonacci() {
        int n = 19;
        System.out.println(f1(n));
        System.out.println(f2(n));
        System.out.println(f3(n));
    }
}
