package org.tequila.novice.class04;

/**
 * @ClassName Node
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/717:11
 * @Version 1.0
 */
public class Node<V> {
    V value;
    Node<V> next;

    public Node(V value) {
        this.value = value;
    }
}
