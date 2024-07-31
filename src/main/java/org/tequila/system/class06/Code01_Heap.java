package org.tequila.system.class06;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @ClassName Code01_Heap
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/2820:15
 * @Version 1.0
 */
public class Code01_Heap {
    @Test
    public void testMyMaxHeap() {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MyMaxHeap my = new MyMaxHeap(curLimit);
            PriorityQueue<Integer> test = new PriorityQueue<>((a, b) -> (b - a));
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.add(curValue);
                } else if (my.isFull()) {
                    if (my.pop() != test.poll()) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (Math.random() < 0.4) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.add(curValue);
                    } else if (Math.random() > 0.7) {
                        if (my.pop() != test.poll()) {
                            System.out.println("Oops!");
                        }
                    } else {
                        if (my.peek() != test.peek()) {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }
}
