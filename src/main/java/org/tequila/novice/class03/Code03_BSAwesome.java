package org.tequila.novice.class03;

import org.junit.Test;

/**
 * @ClassName Code03_BSAwesome
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/610:13
 * @Version 1.0
 */
public class Code03_BSAwesome {


    private int oneMinIndex(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int N = arr.length;
        if (N == 1) {
            return N - 1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }

        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 0;
        int R = N - 1;
        while (L < R - 1) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                return mid;
            } else {
                if (arr[mid - 1] < arr[mid]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    public boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return true;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    @Test
    public void testOneMinIndex() {
        Utils test = new Utils();
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = test.randomArray(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr, ans)) {
                test.printArray(arr);
                System.out.println(ans);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }
}
