package org.tequila.system.class16;

import java.util.ArrayList;

/**
 * @ClassName Node
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2209:28
 * @Version 1.0
 */
public class Node {
    public int in;
    public int out;
    public int value;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
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
