package org.tequila.system.class07;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName Code01_CoverMax
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/109:40
 * @Version 1.0
 */
public class Code01_CoverMax {
    public int maxCover1(int[][] lines) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lines.length; i++) {
            min = Math.min(lines[i][0], min);
            max = Math.max(lines[i][1], max);
        }
        int cover = 0;
        for (double p = min + 0.5; p < max; p++) {
            int cur = 0;
            for (int i = 0; i < lines.length; i++) {
                if (p > lines[i][0] && p < lines[i][1]) {
                    cur++;
                }
            }
            cover = Math.max(cover, cur);
        }
        return cover;
    }

    public int maxCover2(int[][] lines) {
        Arrays.sort(lines, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int cover = 0;
        for (int[] line : lines) {
            while (!queue.isEmpty() && line[0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(line[1]);
            cover = Math.max(cover, queue.size());
        }
        return cover;
    }

    @Test
    public void testMaxCover() {
        System.out.println("test begin");
        int N = 100;
        int L = 0;
        int R = 200;
        int testTimes = 200000;
        Utils utils = new Utils();
        for (int i = 0; i < testTimes; i++) {
            int[][] lines = utils.generateLines(N, L, R);
            int ans1 = maxCover1(lines);
            int ans2 = maxCover2(lines);
            if (ans1 != ans2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test end");
    }
}
