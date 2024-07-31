package org.tequila.novice.class03;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Code01_BSExist
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/608:18
 * @Version 1.0
 */
public class Code01_BSExist {


    private boolean find(int[] arr, int value) {
        if (arr == null || arr.length < 1) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] > value) {
                R = mid - 1;
            } else if (arr[mid] < value) {
                L = mid + 1;
            } else {
                return true;
            }
        }
        return false;

    }

    private boolean test(int[] arr, int value) {
        if (arr == null || arr.length < 1) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testFind() {
        Utils test = new Utils();
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = test.generateRandomArray(10, 100);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != find(arr, value)) {
                System.out.println(value);
                test.printArray(arr);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
