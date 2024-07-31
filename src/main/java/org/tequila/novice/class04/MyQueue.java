package org.tequila.novice.class04;

/**
 * @ClassName MyQueue
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/719:59
 * @Version 1.0
 */
public class MyQueue<V> {
    private Node<V> head;
    private Node<V> tail;
    private int size;

    public MyQueue() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void offer(V value) {
        Node<V> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public V poll() {
        V ans = null;
        if (head != null) {
            ans = head.value;
            head = head.next;
            size--;
        }
        if (head == null) {
            tail = null;
        }
        return ans;
    }

    public V peek() {
        V ans = null;
        if (head != null) {
            ans = head.value;
        }
        return ans;
    }
}
