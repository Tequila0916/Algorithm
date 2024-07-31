package org.tequila.system.class27;

import java.util.ArrayList;

/**
 * @ClassName Code02_TreeEqual
 * @Description https://leetcode.cn/problems/subtree-of-another-tree/
 * @Author GT-R
 * @Date 2023/12/718:36
 * @Version 1.0
 */
public class Code02_TreeEqual {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (subRoot == null) {
            return true;
        }
        ArrayList<String> rootList = preSerial(root);
        ArrayList<String> subList = preSerial(subRoot);
        String[] rootString = new String[rootList.size()];
        for (int i = 0; i < rootString.length; i++) {
            rootString[i] = rootList.get(i);
        }
        String[] subString = new String[subList.size()];
        for (int i = 0; i < subString.length; i++) {
            subString[i] = subList.get(i);
        }
        return getIndexOf(rootString, subString) != -1;
    }

    public int getIndexOf(String[] rootString, String[] subString) {
        if (subString == null || rootString == null || rootString.length < 1 || rootString.length < subString.length) {
            return -1;
        }
        int x = 0;
        int y = 0;
        int[] next = getNextArray(subString);
        while (x < rootString.length && y < subString.length) {
            if (isEqual(rootString[x], subString[y])) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == subString.length ? x - y : -1;
    }

    public int[] getNextArray(String[] subString) {
        if (subString.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[subString.length];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int pre = 0;
        while (index < next.length) {
            if (isEqual(subString[index - 1], subString[pre])) {
                next[index++] = ++pre;
            } else if (pre > 0) {
                pre = next[pre];
            } else {
                next[index++] = 0;
            }
        }
        return next;

    }

    public ArrayList<String> preSerial(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        pres(root, ans);
        return ans;
    }

    public void pres(TreeNode root, ArrayList<String> ans) {
        if (root == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(root.val));
            pres(root.left, ans);
            pres(root.right, ans);
        }
    }

    public boolean isEqual(String a, String b) {
        if (a == null && b == null) {
            return true;
        } else {
            if (a == null || b == null) {
                return false;
            } else {
                return a.equals(b);
            }
        }
    }
}
