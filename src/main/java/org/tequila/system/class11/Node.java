package org.tequila.system.class11;

import java.util.List;

/**
 * @ClassName Node
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/1021:15
 * @Version 1.0
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
