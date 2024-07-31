package org.tequila.novice.class03;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Code02_BSNearLeft
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/608:41
 * @Version 1.0
 */
public class Code02_BSNearLeft {
    private int mostLeftNoLessNumIndex(int[] arr, int value) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                ans = mid;
                R = mid - 1;
            } else if (arr[mid] < value) {
                L = mid + 1;
            }
        }
        return ans;
    }

    private int test(int[] arr, int value) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (value <= arr[i]) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void testMostLeftNoLessNumIndex() {
        Utils test = new Utils();
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = test.generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != mostLeftNoLessNumIndex(arr, value)) {
                test.printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(mostLeftNoLessNumIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
