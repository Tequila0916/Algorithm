package org.tequila.novice.class06;

/**
 * @ClassName Code04_MaximumDepthOfBinaryTree
 * @Description https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * @Author GT-R
 * @Date 2023/7/1021:34
 * @Version 1.0
 */
public class Code04_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth((root.right))) + 1;
    }
}
