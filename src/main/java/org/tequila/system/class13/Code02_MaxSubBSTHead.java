package org.tequila.system.class13;

/**
 * @ClassName Code02_MaxSubBSTHead
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/1615:12
 * @Version 1.0
 */
public class Code02_MaxSubBSTHead {
    public Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info left = process(x.left);
        Info right = process(x.right);
        TreeNode maxSubBSTHead = null;
        int maxSubBSTSize = -1;
        int allSize = 1;
        int min = x.val, max = x.val;
        boolean isBST = true;
        if (left != null) {
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
            maxSubBSTSize = left.maxSubBSTSize;
            maxSubBSTHead = left.maxSubBSTHead;
            allSize += left.allSize;
        }
        if (right != null) {
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
            allSize += right.allSize;
            if (right.maxSubBSTSize > maxSubBSTSize) {
                maxSubBSTSize = right.maxSubBSTSize;
                maxSubBSTHead = right.maxSubBSTHead;
            }
        }
        if (left != null && (!left.isBST || left.max >= x.val)) {
            isBST = false;
        }
        if (right != null && (!right.isBST || right.min <= x.val)) {
            isBST = false;
        }
        if (isBST) {
            maxSubBSTSize = allSize;
            maxSubBSTHead = x;
        }
        return new Info(maxSubBSTHead, allSize, isBST, maxSubBSTSize, min, max);
    }

    public TreeNode maxSubBSTHead(TreeNode head) {
        if (head == null) {
            return null;
        }
        return process(head).maxSubBSTHead;
    }

    public class Info {
        public TreeNode maxSubBSTHead;
        public int allSize;
        public boolean isBST;
        public int maxSubBSTSize;
        public int min;
        public int max;

        public Info(TreeNode maxSubBSTHead, int allSize, boolean isBST, int maxSubBSTSize, int min, int max) {
            this.maxSubBSTHead = maxSubBSTHead;
            this.allSize = allSize;
            this.isBST = isBST;
            this.maxSubBSTSize = maxSubBSTSize;
            this.min = min;
            this.max = max;
        }
    }
}
