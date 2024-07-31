package org.tequila.system.class03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName TwoQueueStack
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1720:46
 * @Version 1.0
 */
public class TwoQueueStack<T> {
    public Queue<T> A;
    public Queue<T> B;

    public TwoQueueStack() {
        A = new LinkedList<T>();
        B = new LinkedList<>();
    }

    public boolean isEmpty() {
        return A.isEmpty();
    }

    public void push(T num) {
        A.offer(num);
    }

    public T peek() {
        while (A.size() > 1) {
            B.offer(A.poll());
        }
        T ans = A.peek();
        B.offer(A.poll());
        Queue temp = A;
        A = B;
        B = temp;
        return ans;
    }

    public T poll() {
        while (A.size() > 1) {
            B.offer(A.poll());
        }
        T ans = A.poll();
        Queue temp = A;
        A = B;
        B = temp;
        return ans;
    }
}
