package org.tequila.system.class12;

/**
 * @ClassName Code02_IsBalanced
 * @Description https://leetcode.cn/problems/balanced-binary-tree/
 * @Author GT-R
 * @Date 2023/8/1608:57
 * @Version 1.0
 */
public class Code02_IsBalanced {
    public Info process(TreeNode x) {
        if (x == null) {
            return new Info(true, 0);
        }
        boolean isBalanced = false;
        int height;
        Info left = process(x.left);
        Info right = process(x.right);
        if (left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2) {
            isBalanced = true;
        }
        height = Math.max(left.height, right.height) + 1;
        return new Info(isBalanced, height);
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
