package org.tequila.system.class32;

/**
 * @ClassName Right
 * @Description TODO
 * @Author GT-R
 * @Date 2024/1/209:46
 * @Version 1.0
 */
public class Right {
    private int[] nums;
    private int N;

    public Right(int size) {
        N = size + 1;
        nums = new int[N + 1];
    }

    public int sum(int index) {
        int ret = 0;
        for (int i = 1; i <= index; i++) {
            ret += nums[i];
        }
        return ret;
    }

    public void add(int index, int d) {
        nums[index] += d;
    }
}
