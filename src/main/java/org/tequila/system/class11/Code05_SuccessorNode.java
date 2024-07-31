package org.tequila.system.class11;

/**
 * @ClassName Code05_SuccessorNode
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/1111:33
 * @Version 1.0
 */
public class Code05_SuccessorNode {
    public Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            if (parent != null && parent.right == node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private Node getLeftMost(Node right) {
        if (right == null) {
            return null;
        }
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }

    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }
}
