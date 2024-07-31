package org.tequila.system.class03;

import java.util.Stack;

/**
 * @ClassName TwoStacksQueue
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1720:36
 * @Version 1.0
 */
public class TwoStacksQueue<T> {
    private Stack<T> popStack;
    private Stack<T> pushStack;

    public TwoStacksQueue() {
        popStack = new Stack<>();
        pushStack = new Stack<>();
    }

    private void pushToPop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public void add(T pushInt) {
        pushStack.push(pushInt);
        pushToPop();
    }

    public T poll(){
        if(popStack.isEmpty()&&pushStack.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return popStack.pop();

    }
    public T peek(){
        if(popStack.isEmpty()&&pushStack.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return popStack.peek();
    }
}
