package org.tequila.system.class30;

/**
 * @ClassName Code02_MinDepth
 * @Description https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @Author GT-R
 * @Date 2023/12/1311:26
 * @Version 1.0
 */
public class Code02_MinDepth {
    public int minDepth1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return function(head);
    }

    public int function(TreeNode head) {
        if (head.right == null && head.left == null) {
            return 1;
        }
        int leftH = Integer.MAX_VALUE;
        int rightH = Integer.MAX_VALUE;
        if (head.left != null) {
            leftH = function(head.left);
        }
        if (head.right != null) {
            rightH = function(head.right);
        }
        return 1 + Math.min(leftH, rightH);
    }


    public int minDepth2(TreeNode head) {
        if (head == null) {
            return 0;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        int curLevel = 0;
        int minHeight = Integer.MAX_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                int rightBoardSize = 1;
                while (mostRight.right != null && mostRight.right != cur) {
                    rightBoardSize++;
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    curLevel++;
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    if(mostRight.left==null){
                        minHeight = Math.min(minHeight,curLevel);
                    }
                    curLevel -= rightBoardSize;
                    mostRight.right = null;
                }
            }else {
                curLevel++;
            }
            cur = cur.right;
        }
        int finalRight = 1;
        cur = head;
        while (cur.right!=null){
            cur = cur.right;
            finalRight++;
        }
        if(cur.left==null&&cur.right==null){
            minHeight = Math.min(minHeight,finalRight);
        }
        return minHeight;
    }

}
