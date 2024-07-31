package org.tequila.system.class01;

/**
 * @ClassName Code05_BSNearLeft
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1411:40
 * @Version 1.0
 */
public class Code05_BSNearLeft {
    public int nearestIndex(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int index = -1;
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }
}
