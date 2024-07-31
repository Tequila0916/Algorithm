package org.tequila.system.class03;

import org.junit.Test;

/**
 * @ClassName Code06_TwoStacksImplementQueue
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1720:42
 * @Version 1.0
 */
public class Code06_TwoStacksImplementQueue {
    @Test
    public  void testTwoStacksQueue() {
        TwoStacksQueue<Integer> test = new TwoStacksQueue<>();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
