package org.tequila.system.class03;

/**
 * @ClassName DoubleEndsQueue
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1716:25
 * @Version 1.0
 */
public class DoubleEndsQueue<T> {
    public DoubleNode<T> head;
    public DoubleNode<T> tail;


    public void addFromHead(T value) {
        DoubleNode node = new DoubleNode(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.last = node;
            node.next = head;
            head = node;
        }

    }

    public void addFromBottom(T value) {
        DoubleNode node = new DoubleNode(value);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.last = tail;
            tail = node;
        }
    }

    public T popFromHead() {
        if (head == null) {
            return null;
        }
        DoubleNode<T> cur = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.last = null;
            cur.next = null;
        }
        return cur.value;
    }

    public T popFromBottom() {
        if (tail == null) {
            return null;
        }
        DoubleNode<T> cur = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.last;
            tail.next = null;
            cur.last = null;
        }
        return cur.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
