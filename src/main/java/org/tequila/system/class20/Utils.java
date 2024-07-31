package org.tequila.system.class20;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author GT-R
 * @Date 2023/9/220:35
 * @Version 1.0
 */
public class Utils {
    public static int[] randomArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }
    public static void printArray(int[] arr) {
        System.out.print("arr : ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + ", ");
        }
        System.out.println();
    }
}
