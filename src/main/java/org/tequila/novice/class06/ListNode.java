package org.tequila.novice.class06;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1020:55
 * @Version 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
