package org.tequila.system.class03;

import org.junit.Test;

/**
 * @ClassName Code05_GetMinStack
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1719:47
 * @Version 1.0
 */
public class Code05_GetMinStack {
    @Test
    public void testMinStack() {
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println("min : " + minStack.getmin());
        minStack.push(4);
        System.out.println("min : " + minStack.getmin());
        minStack.push(1);
        System.out.println("min : " + minStack.getmin());
        System.out.println(minStack.pop());
        System.out.println("min : " + minStack.getmin());
    }
}
