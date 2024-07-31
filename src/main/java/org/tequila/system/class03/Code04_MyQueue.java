package org.tequila.system.class03;

/**
 * @ClassName Code05_MyQueue
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1716:26
 * @Version 1.0
 */
public class Code04_MyQueue<T> {
    private DoubleEndsQueue<T> queue;

    public Code04_MyQueue() {
        this.queue = new DoubleEndsQueue();
    }

    public void push(T value) {
        queue.addFromBottom(value);
    }

    public T poll() {
        return queue.popFromHead();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
