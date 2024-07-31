package org.tequila.system.class17;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName Graph
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2309:01
 * @Version 1.0
 */
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
