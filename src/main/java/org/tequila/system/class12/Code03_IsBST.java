package org.tequila.system.class12;

/**
 * @ClassName Code03_IsBST
 * @Description https://leetcode.cn/problems/validate-binary-search-tree/
 * @Author GT-R
 * @Date 2023/8/1609:16
 * @Version 1.0
 */
public class Code03_IsBST {
    public Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info left = process(x.left);
        Info right = process(x.right);
        boolean isBST = true;
        int max = x.val, min = x.val;
        if (left != null) {
            max = Math.max(left.max, max);
            min = Math.min(left.min, min);
        }
        if (right != null) {
            max = Math.max(right.max, max);
            min = Math.min(right.min, min);
        }
        if (left != null && (!left.isBST || x.val <= left.max)) {
            isBST = false;
        }
        if (right != null && (!right.isBST || x.val >= right.min)) {
            isBST = false;
        }

        return new Info(isBST, max, min);

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBST;
    }

    public class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
}
