package org.tequila.novice.class04;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/810:08
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
