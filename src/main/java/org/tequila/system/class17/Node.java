package org.tequila.system.class17;

import java.util.ArrayList;

/**
 * @ClassName Node
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2308:18
 * @Version 1.0
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        in = 0;
        out = 0;
        this.value = value;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
