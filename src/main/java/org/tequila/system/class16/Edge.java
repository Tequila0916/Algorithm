package org.tequila.system.class16;

/**
 * @ClassName Edge
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2209:31
 * @Version 1.0
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
