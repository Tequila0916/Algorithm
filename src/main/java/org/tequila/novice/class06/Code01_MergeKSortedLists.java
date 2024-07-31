package org.tequila.novice.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Code01_MergeKSortedLists
 * @Description https://leetcode.cn/problems/merge-k-sorted-lists/
 * @Author GT-R
 * @Date 2023/7/1020:54
 * @Version 1.0
 */
public class Code01_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode t1) {
                return listNode.val - t1.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){
                queue.add(lists[i]);
            }
        }
        if(queue.isEmpty()){
            return null;
        }
        ListNode head = queue.poll();
        ListNode pre = head;
        if(pre.next!=null){
            queue.add(pre.next);
        }
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            pre.next = poll;
            pre = pre.next;
            if(poll.next!=null){
                queue.add(poll.next);
            }
        }
        return head;
    }
}
