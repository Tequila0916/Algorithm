package org.tequila.system.class18;

import org.junit.Test;

/**
 * @ClassName Code02_CardsInLine
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2410:25
 * @Version 1.0
 */
public class Code03_CardsInLine {
    public int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fMap = new int[N][N];
        int[][] gMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fMap[i][j] = -1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                gMap[i][j] = -1;
            }
        }

        int f = f(arr, 0, arr.length - 1, fMap, gMap);
        int g = g(arr, 0, arr.length - 1, fMap, gMap);
        return Math.max(f, g);
    }

    /**
     * 先手函数，arr[L..R]获取最好分数
     * @param arr
     * @param L
     * @param R
     * @param fMap
     * @param gMap
     * @return
     */
    private int f(int arr[], int L, int R, int[][] fMap, int[][] gMap) {
        if (fMap[L][R] != -1) {
            return fMap[L][R];
        }
        int ans;
        if (L == R) {
            ans = arr[L];
        } else {
            int arrL = arr[L] + g(arr, L + 1, R, fMap, gMap);
            int arrR = arr[R] + g(arr, L, R - 1, fMap, gMap);
            ans = Math.max(arrL, arrR);
        }
        fMap[L][R] = ans;
        return ans;
    }

    /**
     * 后手函数，arr[L..R]后手获取最好分数
     * @param arr
     * @param L
     * @param R
     * @param fMap
     * @param gMap
     * @return
     */
    private int g(int[] arr, int L, int R, int[][] fMap, int[][] gMap) {
        if (gMap[L][R] != -1) {
            return gMap[L][R];
        }
        int ans;
        if (L == R) {
            ans = 0;
        } else {
            int arrL = f(arr, L + 1, R, fMap, gMap);
            int arrR = f(arr, L, R - 1, fMap, gMap);
            ans = Math.min(arrL, arrR);
        }
        gMap[L][R] = ans;
        return ans;
    }


    public int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fMap = new int[N][N];
        int[][] gMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            fMap[i][i] = arr[i];
        }
        for (int startCol = 1; startCol < N; startCol++) {
            int L = 0;
            int R = startCol;
            while (R < N) {
                fMap[L][R] = Math.max(fMap[L][L] + gMap[L + 1][R], fMap[R][R] + gMap[L][R - 1]);
                gMap[L][R] = Math.min(fMap[L + 1][R], fMap[L][R - 1]);
                L++;
                R++;
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(fMap[i][j] + " ");
//                System.out.print(gMap[i][j] + " ");
//            }
//            System.out.println();
//        }
        return Math.max(fMap[0][N - 1], gMap[0][N - 1]);
    }

    @Test
    public void testWin() {
        int[] arr = {7, 4, 16, 15, 1};
        int result = win2(arr);
        System.out.println("result = " + result);
    }
}
