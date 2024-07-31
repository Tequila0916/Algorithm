package org.tequila.system.class17;

/**
 * @ClassName Edge
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2308:19
 * @Version 1.0
 */
public class Edge {
    Node from;
    Node to;
    int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
