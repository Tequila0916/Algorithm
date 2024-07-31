package org.tequila.novice.class04;

import org.junit.Test;

/**
 * @ClassName Code06_MergeTwoSortedLinkedList
 * @Description https://leetcode.cn/problems/merge-two-sorted-lists/
 * @Author GT-R
 * @Date 2023/7/810:12
 * @Version 1.0
 */
public class Code04_MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val < head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    @Test
    public void testMerge() {
        ListNode listNodeOne = new ListNode(1);
        listNodeOne.next = new ListNode(2);
        listNodeOne.next.next = new ListNode(4);
        listNodeOne.next.next.next = new ListNode(5);
        ListNode listNodeTwo = new ListNode(3);
        ListNode node = mergeTwoLists(listNodeOne, listNodeTwo);
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
