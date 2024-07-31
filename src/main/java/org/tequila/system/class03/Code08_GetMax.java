package org.tequila.system.class03;

/**
 * @ClassName Code08_GetMax
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1809:02
 * @Version 1.0
 */
public class Code08_GetMax {
    public int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int left = process(arr, L, mid);
        int right = process(arr, mid + 1, R);
        return Math.max(left, right);

    }

}
