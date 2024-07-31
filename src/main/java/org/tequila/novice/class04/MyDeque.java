package org.tequila.novice.class04;

/**
 * @ClassName MyDeque
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/721:06
 * @Version 1.0
 */
public class MyDeque<V> {
    private DoubleNode<V> head;
    private DoubleNode<V> tail;
    private int size;

    public MyDeque() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void pushHead(V value) {
        DoubleNode<V> node = new DoubleNode<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.last = node;
            head = node;
        }
        size++;
    }

    public void pushTail(V value) {
        DoubleNode<V> node = new DoubleNode<>(value);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.last = tail;
            tail = node;
        }
        size++;
    }

    public V pollHead() {
        V ans = null;
        if (head == null) {
            return ans;
        }
        ans = head.value;
        size--;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.last = null;
        }
        return ans;
    }

    public V pollTail() {
        V ans = null;
        if (tail == null) {
            return ans;
        }
        ans = tail.value;
        size--;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.last;
            tail.next = null;
        }
        return ans;
    }

    public V peekHead() {
        V ans = null;
        if (head != null) {
            ans = head.value;
        }
        return ans;
    }

    public V peekTail() {
        V ans = null;
        if (tail != null) {
            ans = tail.value;
        }
        return ans;
    }
}
