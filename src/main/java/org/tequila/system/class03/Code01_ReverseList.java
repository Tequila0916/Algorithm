package org.tequila.system.class03;

/**
 * @ClassName Code01_ReverseList
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1710:44
 * @Version 1.0
 */
public class Code01_ReverseList {
    public Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
