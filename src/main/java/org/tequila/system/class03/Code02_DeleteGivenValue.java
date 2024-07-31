package org.tequila.system.class03;

/**
 * @ClassName Code02_DeleteGivenValue
 * @Description https://leetcode.cn/problems/remove-linked-list-elements/
 * @Author GT-R
 * @Date 2023/7/1710:52
 * @Version 1.0
 */
public class Code02_DeleteGivenValue {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;

            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        pre.next = null;
        return head;
    }
}
