package org.tequila.novice.class04;

/**
 * @ClassName DoubleNode
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/717:12
 * @Version 1.0
 */
public class DoubleNode<V> {
    V value;
    DoubleNode<V> next;
    DoubleNode<V> last;

    public DoubleNode(V value) {
        this.value = value;
    }
}
