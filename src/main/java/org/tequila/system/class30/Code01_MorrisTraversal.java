package org.tequila.system.class30;

import org.junit.Test;

/**
 * @ClassName Code01_MorrisTraversal
 * @Description 假设来到当前节点cur，开始时cur来到头节点位置
 * 1）如果cur没有左孩子，cur向右移动（cur = cur.right）
 * 2）如果cur有左孩子，找到左子树上最右的节点mostRight：
 * a.如果mostRight的右指针指向空，让其指向cur，然后cur向左移动（cur = cur.left）
 * b.如果mostRight的右指针指向cur，让其指向null，然后cur向右移动（cur = cur.right）
 * 3） cur为空时遍历停止
 * @Author GT-R
 * @Date 2023/12/1311:20
 * @Version 1.0
 */
public class Code01_MorrisTraversal {
    public void morris(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public void morrisPre(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    System.out.print(cur.val + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.print(cur.val + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }


    public void morrisIn(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    public void morrisPos(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    private void printEdge(TreeNode head) {
        TreeNode tail = reverseEdge(head);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverseEdge(tail);

    }

    private TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    @Test
    public void testMorris() {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(7);
        morrisPre(head);
        morrisIn(head);
        morrisPos(head);
    }
}
