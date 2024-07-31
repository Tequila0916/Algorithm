package org.tequila.system.class04;

/**
 * @ClassName Code03_ReversePair
 * @Description https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @Author GT-R
 * @Date 2023/7/1816:08
 * @Version 1.0
 */
public class Code03_ReversePair {
    public int reversePairs(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return process(arr, L, M) + process(arr, M + 1, R) + merge(arr, L, M, R);
    }

    public int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int p1 = M;
        int p2 = R;
        int index = help.length - 1;
        int res = 0;
        while (p1 >= L && p2 > M) {
            res += arr[p1] > arr[p2] ? (p2 - M) : 0;
            help[index--] = arr[p1] <= arr[p2] ? arr[p2--] : arr[p1--];
        }
        while (p1 >= L) {
            help[index--] = arr[p1--];
        }
        while (p2 > M) {
            help[index--] = arr[p2--];
        }
        for (index = 0; index < help.length; index++) {
            arr[L + index] = help[index];
        }
        return res;
    }

}
