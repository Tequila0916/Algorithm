package org.tequila.system.class12;

/**
 * @ClassName Code04_IsFull
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/1610:32
 * @Version 1.0
 */
public class Code05_IsFull {
    public Info process(TreeNode x) {
        if (x == null) {
            return new Info(0, true);
        }
        Info left = process(x.left);
        Info right = process(x.right);
        boolean isFull = left.isFull && right.isFull && left.height == right.height;
        int height = Math.max(left.height, right.height) + 1;
        return new Info(height, isFull);
    }

    public boolean isFull(TreeNode head) {
        if (head == null) {
            return true;
        }
        return process(head).isFull;
    }

    public class Info {
        int height;
        boolean isFull;

        public Info(int height, boolean isFull) {
            this.height = height;
            this.isFull = isFull;
        }
    }
}
