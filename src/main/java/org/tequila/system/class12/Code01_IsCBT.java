package org.tequila.system.class12;

import java.util.LinkedList;

/**
 * @ClassName Code01_IsCBT
 * @Description https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 * @Author GT-R
 * @Date 2023/8/1608:29
 * @Version 1.0
 */
public class Code01_IsCBT {
    public boolean isCBT1(TreeNode head) {
        if (head == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.push(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }
}
