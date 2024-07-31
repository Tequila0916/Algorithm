package org.tequila.novice.class06;

/**
 * @ClassName Code02_SameTree
 * @Description https://leetcode.cn/problems/same-tree/
 * @Author GT-R
 * @Date 2023/7/1020:48
 * @Version 1.0
 */
public class Code02_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
