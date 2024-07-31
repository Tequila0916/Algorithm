package org.tequila.system.class11;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Code01_LevelTraversalBT
 * @Description
 * @Author GT-R
 * @Date 2023/8/1009:20
 * @Version 1.0
 */
public class Code01_LevelTraversalBT {
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.val + " ");
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    @Test
    public void testLevelOrder() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        levelOrder(head);
    }
}
