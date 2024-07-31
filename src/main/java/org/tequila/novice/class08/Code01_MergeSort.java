package org.tequila.novice.class08;

/**
 * @ClassName Code01_MergeSort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1116:26
 * @Version 1.0
 */
public class Code01_MergeSort {
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int index = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args) {
        Utils test = new Utils();
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = test.generateRandomArray(maxSize, maxValue);
            int[] arr2 = test.copyArray(arr1);
            mergeSort1(arr1);
            mergeSort2(arr2);
            if (!test.isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                test.printArray(arr1);
                test.printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }

    private static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int step = 1;
        while (step < N) {
            int L = 0;
            while (L < N) {
                if (N - L <= step) {
                    break;
                }
                int M = L + step - 1;
                int R = M + Math.min(step, N - 1 - M);
                merge(arr, L, M, R);
                L = R + 1;
            }


            if (step > N / 2) {
                break;
            }
            step <<= 1;
        }

    }
}
