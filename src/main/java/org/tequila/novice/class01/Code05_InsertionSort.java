package org.tequila.novice.class01;

import org.junit.Test;

/**
 * @ClassName Code05_InsertionSort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/411:19
 * @Version 1.0
 */
public class Code05_InsertionSort {
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public void insertionSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    public void insertionSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end <= N - 1; end++) {
            int newIndex = end;
            while (newIndex - 1 >= 0 && arr[newIndex - 1] > arr[newIndex]) {
                swap(arr, newIndex, newIndex - 1);
                newIndex--;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test_InsertionSort() {
        int[] arr = {4, 3, 5, 6, 2, 1, 13, 9, 6, 7, 8};
        printArray(arr);
        insertionSort2(arr);
        printArray(arr);

    }
}
