package org.tequila.system.class11;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Code03_EncodeNaryTreeToBinaryTree
 * @Description https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree
 * @Author GT-R
 * @Date 2023/8/1021:14
 * @Version 1.0
 */
public class Code03_EncodeNaryTreeToBinaryTree {
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode head = new TreeNode(root.val);
        head.left = en(root.children);
        return head;
    }

    private TreeNode en(List<Node> children) {
        TreeNode head = null;
        TreeNode cur = null;
        for (Node child : children) {
            TreeNode treeNode = new TreeNode(child.val);
            if (head == null) {
                head = treeNode;
            } else {
                cur.right = treeNode;
            }
            cur = treeNode;
            cur.left = en(child.children);
        }
        return head;
    }

    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        return new Node(root.val, de(root.left));
    }

    private List<Node> de(TreeNode root) {
        List<Node> children = new LinkedList<>();
        while (root != null) {
            Node cur = new Node(root.val, de(root.left));
            children.add(cur);
            root = root.right;
        }
        return children;
    }
}
