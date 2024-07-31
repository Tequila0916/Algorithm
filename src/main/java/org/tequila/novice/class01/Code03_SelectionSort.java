package org.tequila.novice.class01;

import org.junit.Test;

/**
 * @ClassName Code03_Sort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/410:40
 * @Version 1.0
 */
public class Code03_SelectionSort {

    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, minIndex, i);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Test
    public void testSelectionSort() {
        int[] arr = {1, 4, 5, 4, 64, 3, 45, 63, 5, 67, 7, 3, 44, 52, 45, 23, 45, 236, 2};
        printArray(arr);
        selectSort(arr);
        printArray(arr);
    }
}
