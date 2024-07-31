package org.tequila.system.class04;

/**
 * @ClassName Code02_SmallSum
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1811:09
 * @Version 1.0
 */
public class Code02_SmallSum {
    public int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return process(arr, L, M) + process(arr, M = 1, R) + merge(arr, L, M, R);
    }

    private int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int index = 0;
        int p1 = L;
        int p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        for (index = 0; index < help.length; index++) {
            arr[L + index] = help[index];
        }
        return res;
    }
}
