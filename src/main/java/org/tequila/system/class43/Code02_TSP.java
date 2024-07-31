package org.tequila.system.class43;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code02_TSP
 * @Description TODO
 * @Author GT-R
 * @Date 2024/2/2521:52
 * @Version 1.0
 */
public class Code02_TSP {

    public int t1(int[][] matrix) {
        int N = matrix.length; // 0...N-1
        // set
        // set.get(i) != null i这座城市在集合里
        // set.get(i) == null i这座城市不在集合里
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            set.add(1);
        }
        return func1(matrix, set, 0);
    }

    private int func1(int[][] matrix, List<Integer> set, int start) {
        int cityNum = 0;
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) != null) {
                cityNum++;
            }
        }
        if (cityNum == 1) {
            return matrix[start][0];
        }
        set.set(start, null);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) != null) {
                int cur = matrix[start][i] + func1(matrix, set, i);
                min = Math.min(min, cur);
                ;
            }
        }
        set.set(start, 1);
        return min;
    }
}
