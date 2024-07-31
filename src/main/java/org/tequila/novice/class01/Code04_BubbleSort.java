package org.tequila.novice.class01;

import org.junit.Test;

/**
 * @ClassName Code04_BubbleSort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/410:59
 * @Version 1.0
 */
public class Code04_BubbleSort {
    public void printArray(int[] arr) {
        for (int num :
                arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = N - 1; end > 0; end--) {
            for (int second = 1; second <= end; second++) {
                if (arr[second] < arr[second - 1]) {
                    swap(arr, second, second - 1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void testBubbleSort() {
        int[] arr = {1, 4, 5, 4, 64, 3, 45, 63, 5, 67, 7, 3, 44, 52, 45, 23, 45, 236, 2};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
