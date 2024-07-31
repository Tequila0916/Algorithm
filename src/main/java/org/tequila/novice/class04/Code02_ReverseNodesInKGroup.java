package org.tequila.novice.class04;

/**
 * @ClassName Code04_ReverseNodesInKGroup
 * @Description https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * @Author GT-R
 * @Date 2023/7/721:46
 * @Version 1.0
 */
public class Code02_ReverseNodesInKGroup {
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public void reverse(ListNode start, ListNode end) {
        ListNode pre = end.next;
        ListNode next = null;
        while (pre != end) {
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(head, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode lastend = start;
        while (lastend.next != null) {
            start = lastend.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastend.next = end;
            lastend = start;
        }
        return head;
    }
}
