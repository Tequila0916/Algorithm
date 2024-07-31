package org.tequila.system.class02;

/**
 * @ClassName Code03_KM
 * @Description 输入一定能够保证，数组中所有的数都出现了M次，只有一种数出现了K次，1 <= K < M，返回出现K次的数
 *              https://leetcode.cn/problems/single-number-ii/
 * @Author GT-R
 * @Date 2023/7/1414:55
 * @Version 1.0
 */
public class Code03_KM {
    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] help = new int[32];
        for (int num : arr) {
            for (int j = 0; j < 32; j++) {
                help[j] += (num >> j) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            help[i] %= m;
            if (help[i] != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
