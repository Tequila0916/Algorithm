package org.tequila.novice.class07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Code01_BinaryTreeLevelOrderTraversalII
 * @Description https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 * @Author GT-R
 * @Date 2023/7/1109:30
 * @Version 1.0
 */
public class Code01_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            ans.add(0,list);
        }
        return ans;
    }
}
