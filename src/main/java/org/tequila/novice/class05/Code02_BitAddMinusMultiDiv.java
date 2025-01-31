package org.tequila.novice.class05;

/**
 * @ClassName Code02_BitAddMinusMultiDiv
 * @Description https://leetcode.cn/problems/divide-two-integers/
 * @Author GT-R
 * @Date 2023/7/908:35
 * @Version 1.0
 */
public class Code02_BitAddMinusMultiDiv {
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        if (b != 0) {
            if ((b & 1) != 0) {
                add(a, res);
            }
            b >>>= 1;
            a <<= 1;
        }
        return res;
    }
    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >=0; minus(i,1)) {
            if((x>>i)>=y){
                res |= (1 << i);
                x = minus(x,y<<i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = div(add(a, 1), b);
                return add(c, div(minus(a, multi(c, b)), b));
            }
        } else {
            return div(a, b);
        }
    }
}
