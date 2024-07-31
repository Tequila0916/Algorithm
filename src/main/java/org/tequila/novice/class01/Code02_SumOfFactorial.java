package org.tequila.novice.class01;

import org.junit.Test;

/**
 * @ClassName Code02_SumOfFactorial
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/408:48
 * @Version 1.0
 */
public class Code02_SumOfFactorial {
    public long factorial(int N) {
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= i;
        }
        return ans;
    }

    public long f1(int N) {
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += factorial(i);
        }
        return ans;
    }

    public long f2(int N) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            ans = ans + cur;
        }
        return ans;
    }

    @Test
    public void testFactorial() {
        int N = 10;
        System.out.println(f1(N));
        System.out.println(f2(N));
    }
}
