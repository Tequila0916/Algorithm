package org.tequila.system.class24;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/108:41
 * @Version 1.0
 */
public class Utils {
    public static int[] randomArray(int N, int maxValue) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int) (Math.random() * maxValue) + 1;
        }
        return arr;
    }

    // 为了测试
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
