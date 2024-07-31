package org.tequila.system.class06;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @ClassName Code03_SortArrayDistanceLessK
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/2821:55
 * @Version 1.0
 */
public class Code03_SortArrayDistanceLessK {
    public void sortedArrDistanceLessK(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return;
        }
        if (k == 0) {
            return;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int index = 0;
        for (; index <= Math.min(arr.length - 1, k); ) {
            queue.add(arr[index++]);
        }
        int i = 0;
        for (; index < arr.length; ) {
            arr[i++] = queue.poll();
            queue.add(arr[index++]);
        }
        while (!queue.isEmpty()) {
            arr[i++] = queue.poll();
        }
    }

    @Test
    public void testSortArrayLessK() {
        System.out.println("test begin");
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        Utils utils = new Utils();
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int k = (int) (Math.random() * maxSize) + 1;
            int[] arr = utils.randomArrayNoMoveMoreK(maxSize, maxValue, k);
            int[] arr1 = utils.copyArray(arr);
            int[] arr2 = utils.copyArray(arr);
            sortedArrDistanceLessK(arr1, k);
            utils.comparator(arr2);
            if (!utils.isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println("K : " + k);
                utils.printArray(arr);
                utils.printArray(arr1);
                utils.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
