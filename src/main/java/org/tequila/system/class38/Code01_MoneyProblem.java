package org.tequila.system.class38;

import org.junit.Test;

/**
 * @ClassName Code01_MoneyProblem
 * @Description TODO
 * @Author GT-R
 * @Date 2024/1/3015:17
 * @Version 1.0
 */
public class Code01_MoneyProblem {
    // int[] d d[i]：i号怪兽的武力
    // int[] p p[i]：i号怪兽要求的钱
    // ability 当前你所具有的能力
    // index 来到了第index个怪兽的面前

    // 目前，你的能力是ability，你来到了index号怪兽的面前，如果要通过后续所有的怪兽，
    // 请返回需要花的最少钱数

    public long process2(int[] d, int[] p, int index, int money) {
        if (index == -1) {
            return money == 0 ? 0 : -1;
        }
        long preAbility1 = process2(d, p, index - 1, money);
        long p1 = -1;
        if (preAbility1 != -1 && preAbility1 >= d[index]) {
            p1 = preAbility1;
        }
        long preAbility2 = process2(d, p, index - 1, money - p[index]);
        long p2 = -1;
        if (preAbility2 != -1) {
            p2 = d[index] + preAbility2;
        }
        return Math.max(p1, p2);
    }

    public int minMoney2(int[] d, int[] p) {
        int allMoney = 0;
        for (int i : p) {
            allMoney += i;
        }
        int N = d.length;
        for (int i = 0; i < allMoney; i++) {
            if (process2(d, p, N - 1, i) != -1) {
                return i;
            }
        }
        return allMoney;
    }

    public long process1(int[] d, int[] p, int ability, int index) {
        if (index == d.length) {
            return 0;
        }
        if (ability < d[index]) {
            return p[index] + process1(d, p, ability + d[index], index + 1);
        } else {
            return Math.min(p[index] + process1(d, p, ability + d[index], index + 1), 0 + process1(d, p, ability, index + 1));
        }
    }

    public long func1(int[] d, int[] p) {
        return process1(d, p, 0, 0);
    }

    public int[][] generateTwoRandomArray(int len, int value) {
        int size = (int) (Math.random() * len) + 1;
        int[][] arrs = new int[2][size];
        for (int i = 0; i < size; i++) {
            arrs[0][i] = (int) (Math.random() * value) + 1;
            arrs[1][i] = (int) (Math.random() * value) + 1;
        }
        return arrs;
    }

    @Test
    public void testMoneyProblem() {
        int len = 10;
        int value = 20;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int[][] arrs = generateTwoRandomArray(len, value);
            int[] d = arrs[0];
            int[] p = arrs[1];
            long ans1 = func1(d, p);
//            long ans2 = func2(d, p);
//            long ans3 = func3(d, p);
            long ans4 = minMoney2(d, p);
//            if (ans1 != ans2 || ans2 != ans3 || ans1 != ans4) {
            if (ans1 != ans4) {
                System.out.println("oops!");
            }
        }

    }
}
