package org.tequila.system.class14;

import java.util.PriorityQueue;

/**
 * @ClassName Code02_LessMoneySplitGold
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2011:41
 * @Version 1.0
 */
public class Code02_LessMoneySplitGold {
    public int lessMoney(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int result = 0;
        int cur = 0;
        while (queue.size() > 1) {
            cur = queue.poll() + queue.poll();
            result += cur;
            queue.add(cur);
        }
        return result;
    }
}
