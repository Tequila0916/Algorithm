package org.tequila.system.class01;

/**
 * @ClassName Code06_BSAwesome
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1411:53
 * @Version 1.0
 */
public class Code06_BSAwesome {
    public int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (N == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 1;
        int R = N - 2;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else {
                return mid;
            }
        }
        return L;
    }
}
