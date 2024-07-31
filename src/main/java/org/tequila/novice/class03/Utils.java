package org.tequila.novice.class03;

/**
 * @ClassName UtilForTest
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/610:09
 * @Version 1.0
 */
public class Utils {
    public int[] generateRandomArray(int maxSize, int maxValue) {
        int len = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);

            }
        }
        return arr;
    }

    public void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
