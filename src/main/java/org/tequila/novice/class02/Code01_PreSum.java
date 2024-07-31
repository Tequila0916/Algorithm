package org.tequila.novice.class02;

/**
 * @ClassName Code01_PreSum
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/520:58
 * @Version 1.0
 */
public class Code01_PreSum {
    private static int[] help;

    public static int[] RangeSum(int[] arr) {
        if (arr != null) {
            help = new int[arr.length];
        }
        help[0] = arr[0];
        for (int i = 1; i < help.length; i++) {
            help[i] = arr[i] + help[i - 1];
        }
        return help;

    }

    public static int sum(int[] arr, int L, int R) {
        int[] help = RangeSum(arr);
        return L == 0 ? help[R] : help[R] - help[L - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 6, 7, 8};
        System.out.println(sum(arr, 0, 3));
    }
}
