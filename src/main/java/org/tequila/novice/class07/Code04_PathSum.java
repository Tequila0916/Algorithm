package org.tequila.novice.class07;

/**
 * @ClassName Code03_PathSum
 * @Description https://leetcode.cn/problems/path-sum/
 * @Author GT-R
 * @Date 2023/7/1110:44
 * @Version 1.0
 */
public class Code04_PathSum {
    public boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        ans =false;
        process(root,0,targetSum);
        return ans;
    }
    public void process(TreeNode node,int preSum,int targetSum){
        if(node.left==null&& node.right==null){
            if(preSum + node.val==targetSum){
                ans = true;
                return;
            }
        }
        preSum += node.val;
        if(node.left!=null){
           process(node.left,preSum,targetSum);
        }
        if(node.right!=null){
            process(node.right,preSum,targetSum);
        }
    }
}
