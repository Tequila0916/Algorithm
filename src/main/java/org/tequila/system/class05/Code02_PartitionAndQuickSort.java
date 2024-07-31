package org.tequila.system.class05;

import org.junit.Test;

/**
 * @ClassName Code02_PartitionAndQuickSort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/2617:09
 * @Version 1.0
 */
public class Code02_PartitionAndQuickSort {
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, R, ++lessEqual);
        return lessEqual;
    }

    public int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1; // < 区 右边界
        int more = R; // > 区 左边界
        int index = L;
        while (index < more) {
            if (arr[index] < arr[R]) {
                swap(arr, ++less, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --more, index);
            } else {
                index++;
            }
        }
        swap(arr, R, more);
        return new int[]{++less, more};
    }

    public void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    private void process1(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = partition(arr, l, r);
        process1(arr, l, mid - 1);
        process1(arr, mid + 1, r);
    }

    public void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    private void process2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] help = netherlandsFlag(arr, l, r);
        process2(arr, l, help[0] - 1);
        process2(arr, help[1] + 1, r);
    }

    public void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    private void process3(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] help = netherlandsFlag(arr, l, r);
        process2(arr, l, help[0] - 1);
        process2(arr, help[1] + 1, r);
    }

    @Test
    public void testQuickSort() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        Utils utils = new Utils();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = utils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = utils.copyArray(arr1);
            int[] arr3 = utils.copyArray(arr1);
            quickSort1(arr1);
            quickSort2(arr2);
            quickSort3(arr3);
            if (!utils.isEqual(arr1, arr2) || !utils.isEqual(arr2, arr3)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");
    }
}
