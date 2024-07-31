package org.tequila.system.class11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Code02_SerializeAndReconstructTree
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/1009:43
 * @Version 1.0
 */
public class Code02_SerializeAndReconstructTree {
    public Queue<String> preSerial(TreeNode head) {
        Queue<String> queue = new LinkedList<>();
        pres(head, queue);
        return queue;
    }

    public void pres(TreeNode head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.val));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }

    public TreeNode buildByPreQueue(Queue<String> prelist) {
        if (prelist == null || prelist.size() < 1) {
            return null;
        }
        return preb(prelist);
    }

    public TreeNode preb(Queue<String> prelist) {
        String poll = prelist.poll();
        if (poll == null) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(poll));
        root.left = preb(prelist);
        root.right = preb(prelist);
        return root;
    }

    public Queue<String> levelSerial(TreeNode head) {
        Queue<String> ans = new LinkedList<>();
        if (head != null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.val));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (head.left != null) {
                    ans.add(String.valueOf(head.left.val));
                    queue.add(head.left);
                } else {
                    ans.add(null);
                }
                if (head.right != null) {
                    ans.add(String.valueOf(head.right.val));
                    queue.add(head.right);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    public TreeNode buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.isEmpty()) {
            return null;
        }
        TreeNode head = generateNode(levelList.poll());
        Queue<TreeNode> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            poll.left = generateNode(levelList.poll());
            poll.right = generateNode(levelList.poll());
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return head;
    }

    public TreeNode generateNode(String val) {
        if (val == null) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }

}
