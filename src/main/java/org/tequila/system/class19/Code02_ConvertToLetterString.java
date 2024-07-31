package org.tequila.system.class19;

import org.junit.Test;

/**
 * @ClassName Code02_ConvertToLetterString
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2714:42
 * @Version 1.0
 */
public class Code02_ConvertToLetterString {
    private int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    private int process(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        int ways = process(str, index + 1);
        if (index + 1 < str.length && (str[index] - '0') * 10 + str[index + 1] - '0' < 27) {
            ways += process(str, index + 2);
        }
        return ways;
    }

    public int dp1(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int N = chars.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int index = N - 1; index >= 0; index--) {
            if (chars[index] != '0') {
                int ways = dp[index + 1];
                if (index + 1 < N && (chars[index] - '0') * 10 + chars[index + 1] - '0' < 27) {
                    ways += dp[index + 2];
                }
                dp[index] = ways;
            }
        }
        return dp[0];
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        char[] str = s.toCharArray();
//        int N = str.length;
//        int[] dp = new int[N + 1];
//        dp[N] = 1;
//        for (int index = N - 1; index >= 0; index--) {
//            if (str[index] != '0') {
//                int ways = dp[index + 1];
//                if (index + 1 < N && (str[index] - '0') * 10 + str[index + 1] - '0' < 27) {
//                    ways += dp[index + 2];
//                }
//                dp[index] = ways;
//            }
//        }
//        return dp[0];
    }


    @Test
    public void testConvertToLetterString() {
        int N = 30;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * N);
            String s = Utils.randomString(len);
            int ans0 = number(s);
            int ans1 = dp1(s);
            //int ans2 = dp2(s);
            if (ans0 != ans1
//                    || ans0 != ans2
            ) {
                System.out.println(s);
                System.out.println(ans0);
                System.out.println(ans1);
//                System.out.println(ans2);
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
