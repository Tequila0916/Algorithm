package org.tequila.novice.class02;

/**
 * @ClassName Code03_Comp
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/522:32
 * @Version 1.0
 */
public class Code03_Comp {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            swap(arr, index, i);
        }
    }

    public static void main(String[] args) {
        int maxLen = 50;
        int maxValue = 100;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
            int[] arr2 = copyArrays(arr1);
//            selectionSort(arr1);
            insertionSort(arr1);
            if (!isSorted(arr1)) {
                for (int j = 0; j < arr2.length; j++) {
                    System.out.print(arr2[j] + " ");
                }
                System.out.println();
                System.out.println("排序错了！");
                break;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    public static int[] copyArrays(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static boolean equalValues(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }
}
