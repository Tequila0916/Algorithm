package org.tequila.novice.class04;

/**
 * @ClassName MyStack
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/720:23
 * @Version 1.0
 */
public class MyStack<V> {
    private int size;
    private Node<V> head;


    public MyStack() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(V value) {
        Node<V> node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public V pop() {
        V ans = null;
        if (head != null) {
            ans = head.value;
            head = head.next;
            size--;
        }

        return ans;
    }

    public V peek() {
        return head == null ? null : head.value;
    }

}
