package org.tequila.system.class01;

/**
 * @ClassName Code01_SelectionSort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1409:16
 * @Version 1.0
 */
public class Code01_SelectionSort {
    public void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                minIndex = arr[j]<arr[minIndex]?j:minIndex;
            }
            swap(arr,minIndex,i);
        }
    }
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
