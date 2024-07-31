package org.tequila.system.class09;

import org.junit.Test;

/**
 * @ClassName Code03_SmallerEqualBigger
 * @Description https://leetcode.cn/problems/partition-list/
 *
 * @Author GT-R
 * @Date 2023/8/813:17
 * @Version 1.0
 */
public class Code03_SmallerEqualBigger {
    public void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, index++, ++small);
            } else if (nodeArr[index].value > pivot) {
                swap(nodeArr, index, --big);
            } else {
                index++;
            }
        }
    }

    private void swap(Node[] nodeArr, int i, int j) {
        Node temp = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = temp;
    }

    public Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodes = new Node[i];
        cur = head;
        for (i = 0; i < nodes.length; i++) {
            nodes[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodes, pivot);
        for (i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        nodes[i].next = null;
        return nodes[0];

    }

    public Node listPartition2(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node mH = null; // big head
        Node mT = null; // big tail
        Node next = null; // save next node
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = sT.next;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = eT.next;
                }
            } else if (head.value > pivot) {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = mT.next;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) { // 如果小于区域和等于区域，不是都没有
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }

    @Test
    public void testPartition() {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        Utils utils = new Utils();
        utils.printLinkedList(head1);
//        head1 = listPartition1(head1, 5);
        head1 = listPartition2(head1, 5);
        utils.printLinkedList(head1);

    }
}
