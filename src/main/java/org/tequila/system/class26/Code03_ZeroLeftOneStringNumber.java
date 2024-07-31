package org.tequila.system.class26;

import org.junit.Test;

/**
 * @ClassName Code03_ZeroLeftOneStringNumber
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/411:15
 * @Version 1.0
 */
public class Code03_ZeroLeftOneStringNumber {
    public int getNum1(int n) {
        if (n < 1) {
            return 0;
        }
        return process(1, n);
    }

    private int process(int i, int n) {
        if (i == n - 1) {
            return 2;
        }
        if (i == n) {
            return 1;
        }
        return process(i + 1, n) + process(i + 2, n);
    }

    public int getNum2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 1;
        int res = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res = res + pre;
            pre = temp;
        }
        return res;
    }

    public int getNum3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] rest = matrixPower(base, n - 2);
        return 2 * rest[0][0] + rest[0][1];
    }

    private int[][] matrixPower(int[][] base, int k) {
        int res[][] = new int[base.length][base[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] t = base;
        for (; k != 0; k >>= 1) {
            if ((k & 1) != 0) {
                res = product(res, t);
            }
            t = product(t, t);
        }
        return res;
    }

    private int[][] product(int[][] a, int[][] b) {
        int n = a.length;
        int k = a[0].length;
        int m = b[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int c = 0; c < k; c++) {
                    ans[i][j] += a[i][c] * b[c][j];
                }
            }
        }
        return ans;
    }

    @Test
    public void testGetNum() {
        for (int i = 0; i != 20; i++) {
            if (getNum1(i) != getNum2(i) && getNum2(i) != getNum3(i)) {
                System.out.println("ERROR");
            }
        }
        System.out.println("Success");
    }
}
