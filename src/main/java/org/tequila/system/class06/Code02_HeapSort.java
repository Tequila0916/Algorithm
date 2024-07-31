package org.tequila.system.class06;

import org.junit.Test;

/**
 * @ClassName Code02_HeapSort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/2821:03
 * @Version 1.0
 */
public class Code02_HeapSort {
    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void swap(int[] arr, int index, int change) {
        int temp = arr[index];
        arr[index] = arr[change];
        arr[change] = temp;
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int change = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            change = arr[change] > arr[index] ? change : index;
            if (change == index) break;
            swap(arr, change, index);
            index = change;
            left = index * 2 + 1;
        }
    }

    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    @Test
    public void testHeapSort() {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        Utils utils = new Utils();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = utils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = utils.copyArray(arr1);
            heapSort(arr1);
            utils.comparator(arr2);
            if (!utils.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = utils.generateRandomArray(maxSize, maxValue);
        utils.printArray(arr);
        heapSort(arr);
        utils.printArray(arr);
    }
}
