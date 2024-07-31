package org.tequila.system.class30;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/1311:20
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
