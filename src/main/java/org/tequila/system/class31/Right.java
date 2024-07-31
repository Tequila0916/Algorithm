package org.tequila.system.class31;

/**
 * @ClassName Right
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/1517:03
 * @Version 1.0
 */
public class Right {
    public int[] arr;

    public Right(int[] origin) {
        arr = new int[origin.length + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = origin[i - 1];
        }
    }

    public void update(int L, int R, int C) {
        for (int i = L; i <= R; i++) {
            arr[i] = C;
        }
    }

    public void add(int L, int R, int C) {
        for (int i = L; i <= R; i++) {
            arr[i] += C;
        }
    }

    public long query(int L, int R) {
        long ans = 0;
        for (int i = L; i <= R; i++) {
            ans += arr[i];
        }
        return ans;
    }
}
