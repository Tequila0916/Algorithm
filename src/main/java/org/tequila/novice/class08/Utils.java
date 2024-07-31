package org.tequila.novice.class08;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1116:33
 * @Version 1.0
 */
public class Utils {
    public int[] generateRandomArray(int maxSize, int maxValue) {
        int[] ans = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
        }
        return ans;
    }

    public int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public  boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
