package org.tequila.system.class13;

/**
 * @ClassName Code01_IsCBT
 * @Description https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 * @Author GT-R
 * @Date 2023/8/1613:47
 * @Version 1.0
 */
public class Code01_IsCBT {
    public Info process(TreeNode x) {
        if (x == null) {
            return new Info(true, true, 0);
        }
        Info left = process(x.left);
        Info right = process(x.right);
        boolean isFull = false;
        boolean isCBT = false;
        int height = Math.max(left.height, right.height) + 1;
        if (left.isFull && right.isFull && left.height == right.height + 1) {
            isCBT = true;
        } else if (left.isFull && right.isFull && left.height == right.height) {
            isCBT = true;
            isFull = true;
        } else if (left.isCBT && right.isFull && left.height == right.height + 1) {
            isCBT = true;
        } else if (left.isFull && right.isCBT && left.height == right.height) {
            isCBT = true;
        }
        return new Info(isFull, isCBT, height);
    }

    public boolean isCompleteTree(TreeNode root) {
        return process(root).isCBT;
    }

    public class Info {
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }
}
