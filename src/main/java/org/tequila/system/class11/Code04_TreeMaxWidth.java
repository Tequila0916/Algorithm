package org.tequila.system.class11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Code04_TreeMaxWidth
 * @Description https://leetcode.cn/problems/maximum-width-of-binary-tree/
 * @Author GT-R
 * @Date 2023/8/1022:00
 * @Version 1.0
 */
public class Code04_TreeMaxWidth {
    public int maxWidthNoMap(TreeNode head) {
        if (head == null) {
            return 0;
        }
        TreeNode curEnd = head;
        TreeNode nextEnd = null;
        int max = 0;
        int curLevelNodes = 0; // 当前层的节点数
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            curLevelNodes++;
            if (poll.left != null) {
                queue.add(poll.left);
                nextEnd = poll.left;
            }
            if (poll.right != null) {
                queue.add(poll.right);
                nextEnd = poll.right;
            }
            if (curEnd == poll) {
                max = Math.max(max, curLevelNodes);
                curEnd = nextEnd;
                curLevelNodes = 0;
            }
        }
        return max;
    }
}
