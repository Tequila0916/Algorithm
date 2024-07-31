package org.tequila.system.class17;

/**
 * @ClassName NodeRecord
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2309:47
 * @Version 1.0
 */
public class NodeRecord {
    public Node node;
    public int distance;

    public NodeRecord(Node node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
