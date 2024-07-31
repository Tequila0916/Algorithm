package org.tequila.novice.class08;

import java.util.Stack;

/**
 * @ClassName Code02_QuickSort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1121:14
 * @Version 1.0
 */
public class Code02_QuickSort {
    public static void splitNum_v1(int[] arr) {
        int N = arr.length;
        int min = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] <= arr[N - 1]) {
                swap(arr, ++min, i);
            }
        }
    }

    public static void splitNum_v2(int[] arr) {
        int N = arr.length;
        int min = -1;
        int max = N - 1;
        int index = 0;
        while (index < max) {
            if (arr[index] < arr[N - 1]) {
                swap(arr, ++min, index++);
            } else if (arr[index] > arr[N - 1]) {
                swap(arr, index, --max);
            } else {
                index++;
            }
        }
        swap(arr, N - 1, max);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int[] partition(int[] arr, int L, int R) {
        int min = L - 1;
        int max = R;
        int index = L;
        while (index < max) {
            if (arr[index] < arr[R]) {
                swap(arr, ++min, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, index, --max);
            } else {
                index++;
            }
        }
        swap(arr, R, max);
        return new int[]{min + 1, max};

    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] help = partition(arr, L, R);
        process(arr, L, help[0] - 1);
        process(arr, help[1] + 1, R);
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length - 1));
        while (!stack.isEmpty()) {
            Job job = stack.pop();
            int[] help = partition(arr, job.l, job.r);
            if (help[0] > job.l) {
                stack.push(new Job(job.l, help[0] - 1));
            }
            if (help[1] < job.r) {
                stack.push(new Job(help[0] + 1, job.r));
            }

        }

    }

    public static void main(String[] args) {
        Utils test = new Utils();
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = test.generateRandomArray(maxSize, maxValue);
            int[] arr2 = test.copyArray(arr1);
            quickSort1(arr1);
            quickSort2(arr2);
            if (!test.isEqual(arr1, arr2)) {
                System.out.println("Oops!");
                succeed = false;
                break;
            }
        }
        System.out.println("test end");
        System.out.println(succeed ? "Nice!" : "Oops!");

    }

    public static class Job {
        int l;
        int r;

        public Job(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
