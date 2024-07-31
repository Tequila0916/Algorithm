package org.tequila.system.class09;

import java.util.HashMap;

/**
 * @ClassName Code04_CopyListWithRandom
 * @Description https://leetcode.cn/problems/copy-list-with-random-pointer/
 * @Author GT-R
 * @Date 2023/8/816:02
 * @Version 1.0
 */
public class Code04_CopyListWithRandom {
    public Node copyRandomList1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }

        Node res = head.next;
        cur = head;
        Node copy = null;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next == null ? null : cur.next.next;
            cur = next;
        }
        return res;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
