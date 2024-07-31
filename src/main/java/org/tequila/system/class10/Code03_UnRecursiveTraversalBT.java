package org.tequila.system.class10;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName Code03_UnRecursiveTraversalBT
 * @Description https://leetcode.cn/problems/binary-tree-inorder-traversal/
 *              https://leetcode.cn/problems/binary-tree-preorder-traversal/
 *              https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * @Author GT-R
 * @Date 2023/8/911:28
 * @Version 1.0
 */
public class Code03_UnRecursiveTraversalBT {
    public void pre(TreeNode head) {
        System.out.println("pre-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.print(pop.val + " ");
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }
    }

    public void pos1(TreeNode head) {
        System.out.println("pos-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> ans = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                ans.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!ans.isEmpty()) {
                head = ans.pop();
                System.out.print(head.val + " ");
            }
        }

    }

    public void in(TreeNode cur) {
        System.out.println("in-order: ");
        if (cur != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    TreeNode pop = stack.pop();
                    System.out.print(pop.val + " ");
                    cur = pop.right;
                }
            }
        }
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


        pre(head);
        System.out.println();
        in(head);
        System.out.println();
        pos1(head);
        System.out.println();
    }
}
