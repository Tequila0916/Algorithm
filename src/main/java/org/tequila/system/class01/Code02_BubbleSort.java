package org.tequila.system.class01;

/**
 * @ClassName Code02_BubbleSort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1409:25
 * @Version 1.0
 */
public class Code02_BubbleSort {
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = N - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
