package org.tequila.system.class09;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName Code02_IsPalindromeList
 * @Description https://leetcode.cn/problems/palindrome-linked-list/
 *              https://leetcode.cn/problems/reorder-list/
 * @Author GT-R
 * @Date 2023/8/809:32
 * @Version 1.0
 */
public class Code02_IsPalindromeList {
    public boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head.next;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.value == head.next.value;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        boolean result = true;
        Node right = reverseLinkedList(slow);
        Node tail = right;
        Node left = head;
        while (left != null && right != null) {
            if (left.value != right.value) {
                result = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        reverseLinkedList(tail);
        return result;
    }

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

    public Node reorderList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node left = head.next;
        Node right = reverseLinkedList(slow);
        Node pre = head;
        while (left!= null && right != left) {
            pre.next = right;
            right = right.next;
            pre = pre.next;

            pre.next = left;
            left = left.next;
            pre = pre.next;

        }
        pre.next = left == null ? left : right;
        return head;
    }

    @Test
    public void testIsPalindrome() {

        Node head = null;
        Utils utils = new Utils();
        utils.printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        utils.printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        utils.printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        utils.printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        utils.printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        utils.printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        utils.printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        utils.printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        utils.printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        utils.printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        utils.printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        utils.printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        utils.printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        utils.printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        utils.printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        utils.printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        utils.printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        utils.printLinkedList(head);
        System.out.println("=========================");


        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        utils.printLinkedList(head);
        reorderList(head);
        utils.printLinkedList(head);
        System.out.println("=========================");


        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        utils.printLinkedList(head);
        reorderList(head);
        utils.printLinkedList(head);
        System.out.println("=========================");


    }
}
