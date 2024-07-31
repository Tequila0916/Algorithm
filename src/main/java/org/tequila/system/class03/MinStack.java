package org.tequila.system.class03;

import java.util.Stack;

/**
 * @ClassName MinStack
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1720:12
 * @Version 1.0
 */
public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackMin = new Stack<>();
        stackData = new Stack<>();
    }

    public void push(int newNum) {
        if (stackMin.isEmpty() || getmin() >= newNum) {
            stackMin.push(newNum);
        }


        stackData.push(newNum);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        int ans = stackData.pop();
        if (getmin() == ans) {
            stackMin.pop();
        }
        return ans;
    }

    public int getmin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return stackMin.peek();
    }
}
