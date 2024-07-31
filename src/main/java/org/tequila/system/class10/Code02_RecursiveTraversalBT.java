package org.tequila.system.class10;

import org.junit.Test;

/**
 * @ClassName Code02_RecursiveTraversalBT
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/910:58
 * @Version 1.0
 */
public class Code02_RecursiveTraversalBT {
    public void f(TreeNode head) {
        if (head == null) {
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }

    // 先序打印所有节点
    public void pre(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val+" ");
        pre(head.left);
        pre(head.right);
    }

    public void in(TreeNode head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.print(head.val+" ");
        in(head.right);
    }

    public void pos(TreeNode head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.print(head.val+" ");
    }

    @Test
    public void testTreeNode() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);


        System.out.println("pre-order: ");
        pre(head);
        System.out.println();
        System.out.println("in-order: ");
        in(head);
        System.out.println();
        System.out.println("pos-order: ");
        pos(head);
    }
}
