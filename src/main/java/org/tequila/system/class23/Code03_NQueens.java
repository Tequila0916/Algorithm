package org.tequila.system.class23;

import org.junit.Test;

/**
 * @ClassName Code03_NQueens
 * @Description TODO
 * @Author GT-R
 * @Date 2023/11/2510:09
 * @Version 1.0
 */
public class Code03_NQueens {
    public int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    /**
     *
     * @param i     当前来到i行 一共是0～n-1行
     * @param record record[x] = y 代表第x行的皇后 放在y列上
     * @param n     是固定参数
     * @return  不关心i以前发生了什么，有多少合法的方法数
     */

    public int process(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        // i行的皇后放哪一列
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    /**
     * 检查0～i - 1 的皇后不打架
     * @param record
     * @param i record下标，即行
     * @param j 列
     * @return
     */

    public boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testNum() {
        int n = 7;

        long start = System.currentTimeMillis();
        //System.out.println(num2(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(num1(n));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

    }
}
