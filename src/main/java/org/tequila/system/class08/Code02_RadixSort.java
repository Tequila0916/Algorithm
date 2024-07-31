package org.tequila.system.class08;

import org.junit.Test;

/**
 * @ClassName Code02_CountSort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/210:11
 * @Version 1.0
 */
public class Code02_RadixSort {
    public void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    private int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        while (max != 0) {
            result++;
            max /= 10;
        }
        return result;
    }

    public void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i, j = 0;
        int[] help = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }

        }
    }

    public int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    @Test
    public void testRadixSort() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100000;
        boolean succeed = true;
        Utils utils = new Utils();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = utils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = utils.copyArray(arr1);
            radixSort(arr1);
            utils.comparator(arr2);
            if (!utils.isEqual(arr1, arr2)) {
                succeed = false;
                utils.printArray(arr1);
                utils.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
