package org.tequila.novice.class06;

/**
 * @ClassName Code03_SymmetricTree
 * @Description https://leetcode.cn/problems/symmetric-tree/
 * @Author GT-R
 * @Date 2023/7/1021:26
 * @Version 1.0
 */
public class Code03_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode h1, TreeNode h2) {
        if (h1 == null ^ h2 == null) {
            return false;
        }
        if (h1 == null && h2 == null) {
            return true;
        }
        return h1.val == h2.val && isMirror(h1.right, h2.left) && isMirror(h1.left, h2.right);
    }
}
