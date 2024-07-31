package org.tequila.system.class12;

/**
 * @ClassName Code04_MaxDistance
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/1610:16
 * @Version 1.0
 */
public class Code04_MaxDistance {
    public Info process(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info left = process(x.left);
        Info right = process(x.right);
        int maxDistance, height;
        height = Math.max(left.height, right.height) + 1;
        maxDistance = Math.max(Math.max(left.maxDistance, right.maxDistance), left.height + right.height + 1);
        return new Info(maxDistance, height);
    }

    public int maxDistance(TreeNode head) {
        return process(head).maxDistance;
    }

    public class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }
}
