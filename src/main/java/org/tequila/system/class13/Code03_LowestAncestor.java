package org.tequila.system.class13;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName Code03_lowestAncestor
 * @Description https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 * @Author GT-R
 * @Date 2023/8/1616:01
 * @Version 1.0
 */
public class Code03_LowestAncestor {
    public TreeNode lowestAncestor(TreeNode head, TreeNode a, TreeNode b) {
        return process(head, a, b).ans;
    }

    public Info process(TreeNode head, TreeNode a, TreeNode b) {
        if (head == null) {
            return new Info(false, false, null);
        }
        Info left = process(head.left, a, b);
        Info right = process(head.right, a, b);
        boolean findA = head == a || left.findA || right.findA;
        boolean findB = head == b || left.findB || right.findB;
        TreeNode ans = null;
        if (left.ans != null) {
            ans = left.ans;
        } else if (right.ans != null) {
            ans = right.ans;
        } else if (findA && findB) {
            ans = head;
        }
        return new Info(findA, findB, ans);
    }


    public class Info {
        public boolean findA;
        public boolean findB;
        public TreeNode ans;

        public Info(boolean findA, boolean findB, TreeNode ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }
}
