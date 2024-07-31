package org.tequila.system.class03;

/**
 * @ClassName DoubleNode
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1710:48
 * @Version 1.0
 */
public class DoubleNode<T> {
    public T value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(T data) {
        value = data;
    }
}
