package org.tequila.novice.class06;

import java.util.HashMap;

/**
 * @ClassName Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal
 * @Description https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @Author GT-R
 * @Date 2023/7/1021:37
 * @Version 1.0
 */
public class Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        int N = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(inorder[i], i);
        }
        return recursion(preorder, 0, N - 1, inorder, 0, N - 1, map);
    }

    public TreeNode recursion(int[] pre, int L1, int R1, int[] in, int L2, int R2, HashMap<Integer, Integer> map) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = map.get(pre[L1]);
        /**
         * pre L1 ,               L1 + 1 ... L1 + find - L2,         L1 + find - L2 + 1 ... R1
         * in  L2 ... find - 1 ,  find,                               find + 1 ... R2
         */
        head.left = recursion(pre, L1 + 1,L1 + find - L2,in,L2,find - 1,map);
        head.right = recursion(pre, L1 + find - L2 + 1,R1,in,find + 1,R2,map);
        return head;
    }
}

