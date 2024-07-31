package org.tequila.novice.class07;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code03_IsBinarySearchTree
 * @Description https://leetcode.cn/problems/validate-binary-search-tree/
 * @Author GT-R
 * @Date 2023/7/1110:57
 * @Version 1.0
 */
public class Code03_IsBinarySearchTree {
    public Info process_2(TreeNode node) {
        if (node == null) {
            return null;
        }
        Info leftInfo = process_2(node.left);
        Info rightInfo = process_2(node.right);
        int min = node.val;
        int max = node.val;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        boolean isBst = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBst = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBst = false;
        }
        boolean left = leftInfo == null ? true : leftInfo.max < node.val;
        boolean right = rightInfo == null ? true : rightInfo.min > node.val;
        if(!left || !right){
            isBst=false;
        }
        return new Info(isBst, max, min);
    }

    public boolean isValidBST_2(TreeNode root) {
        return process_2(root).isBST;
    }

    /**
     * 搜索二叉树，中序，一定是一个按照升序排序好的数组
     *
     * @param root
     * @return
     */
    public boolean isValidBST_1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        in(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void in(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        in(root.left, list);
        list.add(root.val);
        in(root.right, list);
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
