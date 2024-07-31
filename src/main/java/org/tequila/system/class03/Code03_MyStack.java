package org.tequila.system.class03;

/**
 * @ClassName Code04_MyStack
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1716:26
 * @Version 1.0
 */
public class Code03_MyStack<T> {
    private DoubleEndsQueue<T> queue;

    public Code03_MyStack() {
        queue = new DoubleEndsQueue<>();
    }
    public void push(T value){
        queue.addFromBottom(value);
    }
    public T pop(){
        return queue.popFromBottom();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
