package org.tequila.novice.class04;

/**
 * @ClassName Code05_AddTwoNumbers
 * @Description https://leetcode.cn/problems/add-two-numbers/
 * @Author GT-R
 * @Date 2023/7/809:31
 * @Version 1.0
 */
public class Code03_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);
        ListNode l = len1 > len2 ? head1 : head2;
        ListNode s = l == head1 ? head2 : head1;
        ListNode curl = l;
        ListNode curs = s;
        ListNode last = curl;
        int carry = 0;
        int sum = 0;
        while (curs != null) {
            sum = curl.val + curs.val + carry;
            curl.val = sum % 10;
            carry = sum / 10;
            last = curl;
            curl = curl.next;
            curs = curs.next;
        }
        while (curl != null) {
            sum = curl.val + carry;
            curl.val = sum % 10;
            carry = sum / 10;
            last = curl;
            curl = curl.next;
        }
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return l;
    }

    public int listLength(ListNode head) {
        int len = 1;
        while (head.next != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
