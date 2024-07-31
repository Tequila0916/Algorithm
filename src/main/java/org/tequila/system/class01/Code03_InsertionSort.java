package org.tequila.system.class01;

/**
 * @ClassName Code03_InsertionSort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1409:30
 * @Version 1.0
 */
public class Code03_InsertionSort {
    public void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }

    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
