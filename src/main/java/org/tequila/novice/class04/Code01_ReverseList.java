package org.tequila.novice.class04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code01_ReverseList
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/716:18
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


    public Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
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

    public DoubleNode testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int N = list.size();
        for (int i = 1; i < N; i++) {
            DoubleNode cur = list.get(i);
            cur.last = null;
            cur.next = pre;
            pre.last = cur;
            pre = cur;
        }
        return list.get(N - 1);
    }

    @Test
    public void testReverse() {
        Utils test = new Utils();
        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            Node node1 = test.generateRandomLinkedList(len, value);
            List<Integer> list1 = test.getLinkedListOriginOrder(node1);
            node1 = reverseLinkedList(node1);
            if (!test.checkLinkedListReverse(list1, node1)) {
                System.out.println("Oops1!");
            }

            Node node2 = test.generateRandomLinkedList(len, value);
            List<Integer> list2 = test.getLinkedListOriginOrder(node2);
            node2 = testReverseLinkedList(node2);
            if (!test.checkLinkedListReverse(list2, node2)) {
                System.out.println("Oops2!");
            }

            DoubleNode node3 = test.generateRandomDoubleList(len, value);
            List<Integer> list3 = test.getDoubleListOriginOrder(node3);
            node3 = reverseDoubleList(node3);
            if (!test.checkDoubleListReverse(list3, node3)) {
                System.out.println("Oops3!");
            }

            DoubleNode node4 = test.generateRandomDoubleList(len, value);
            List<Integer> list4 = test.getDoubleListOriginOrder(node4);
            node4 = reverseDoubleList(node4);
            if (!test.checkDoubleListReverse(list4, node4)) {
                System.out.println("Oops4!");
            }
        }
        System.out.println("test finish!");

    }
}
