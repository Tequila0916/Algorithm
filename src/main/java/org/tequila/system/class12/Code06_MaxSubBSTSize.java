package org.tequila.system.class12;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ClassName Code06_MaxSubBSTSize
 * @Description https://leetcode.cn/problems/largest-bst-subtree/
 * @Author GT-R
 * @Date 2023/8/1611:30
 * @Version 1.0
 */
public class Code06_MaxSubBSTSize {
    public Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info left = process(x.left);
        Info right = process(x.right);
        boolean isBST = true;
        int maxBSTSubtreeSize = -1;
        int max = x.val, min = x.val, allSize = 1;
        if (left != null) {
            max = Math.max(left.max, max);
            min = Math.min(left.min, min);
            allSize += left.allSize;
            maxBSTSubtreeSize = Math.max(maxBSTSubtreeSize, left.maxBSTSubtreeSize);
        }
        if (right != null) {
            max = Math.max(right.max, max);
            min = Math.min(right.min, min);
            allSize += right.allSize;
            maxBSTSubtreeSize = Math.max(maxBSTSubtreeSize, right.maxBSTSubtreeSize);
        }
        if (left != null && (!left.isBST || x.val <= left.max)) {
            isBST = false;
        }
        if (right != null && (!right.isBST || x.val >= right.min)) {
            isBST = false;
        }
        if (isBST) {
            maxBSTSubtreeSize = Math.max(maxBSTSubtreeSize, allSize);
        }
        return new Info(maxBSTSubtreeSize, allSize, isBST, max, min);
    }

    public int largestBSTSubtree(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return process(head).maxBSTSubtreeSize;
    }

    public class Info {
        public int maxBSTSubtreeSize;
        public int allSize;
        public boolean isBST;
        public int max;
        public int min;

        public Info(int maxBSTSubtreeSize, int allSize, boolean isBST, int max, int min) {
            this.maxBSTSubtreeSize = maxBSTSubtreeSize;
            this.allSize = allSize;
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
}
