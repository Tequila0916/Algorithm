package org.tequila.novice.class07;

/**
 * @ClassName Code02_BalancedBinaryTree
 * @Description https://leetcode.cn/problems/balanced-binary-tree/
 * @Author GT-R
 * @Date 2023/7/1110:05
 * @Version 1.0
 */
public class Code02_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public Info process(TreeNode node) {
        if (node == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) < 2;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(isBalanced, height);
    }

    public class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

}
