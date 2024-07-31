package org.tequila.system.class17;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName Code05_ReverseStackUsingRecursive
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2315:14
 * @Version 1.0
 */
public class Code05_ReverseStackUsingRecursive {
    public int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int hold = f(stack);
            stack.push(result);
            return hold;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }

    @Test
    public void testReverse() {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        System.out.println("test = " + test);

    }
}
