package org.tequila.novice.class07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Code05_PathSumII
 * @Description https://leetcode.cn/problems/path-sum-ii/
 * @Author GT-R
 * @Date 2023/7/1115:49
 * @Version 1.0
 */
public class Code05_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        process(root,path,0,targetSum,ans);
        return ans;
    }

    public void process(TreeNode node, List<Integer> path, int preSum, int target, List<List<Integer>> ans) {
        if (node.left == null && node.right == null) {
            if (preSum + node.val == target) {
                path.add(node.val);
                ans.add(copy(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(node.val);
        preSum += node.val;
        if (node.left != null) {
            process(node.left, path, preSum, target, ans);
        }
        if (node.right != null) {
            process(node.right, path, preSum, target, ans);
        }
        path.remove(path.size()-1);
    }
    public List<Integer> copy(List<Integer> path){
        List<Integer> copy = new LinkedList<>();
        for(int num : path){
            copy.add(num);
        }
        return copy;
    }
}
