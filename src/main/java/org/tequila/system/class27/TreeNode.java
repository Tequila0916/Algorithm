package org.tequila.system.class27;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/718:38
 * @Version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
