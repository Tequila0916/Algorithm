package org.tequila.system.class10;

import org.junit.Test;

/**
 * @ClassName Code01_FindFirstIntersectNode
 * @Description https://leetcode.cn/problems/linked-list-cycle/
 *              https://leetcode.cn/problems/linked-list-cycle-ii/
 *              https://leetcode.cn/problems/intersection-of-two-linked-lists/
 *
 * @Author GT-R
 * @Date 2023/8/908:41
 * @Version 1.0
 */
public class Code01_FindFirstIntersectNode {
    public ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode noLoop(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int index = 0;
        while (cur1.next != null) {
            index++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            index--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = index > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        index = Math.abs(index);
        while (index != 0) {
            index--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        ListNode cur1 = null;
        ListNode cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int index = 0;
            while (cur1 != loop1) {
                index++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                index--;
                cur2 = cur2.next;
            }
            cur1 = index > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            index = Math.abs(index);
            while (index != 0) {
                index--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
    public  ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1==null||head2==null){
            return null;
        }
        ListNode loop1 = getLoopNode(head1);

        ListNode loop2 = getLoopNode(head2);
        if(loop1==null&&loop2==null){
            return noLoop(head1,head2);
        }
        if(loop1!=null&&loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }
    @Test
    public void testGetLoopNode() {
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);


        // 0->9->8->6->7->null
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6

        System.out.println(getIntersectionNode(head1,head2).val);


        // 1->2->3->4->5->6->7->4...
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectionNode(head1,head2).val);



        // 0->9->8->6->4->5->6..
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectionNode(head1,head2).val);

    }
}
