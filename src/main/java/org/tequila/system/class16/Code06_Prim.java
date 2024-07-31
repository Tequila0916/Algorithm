package org.tequila.system.class16;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName Code06_Prim
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2214:48
 * @Version 1.0
 */
public class Code06_Prim {
    public  Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> nodeSet = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        for (Node value : graph.nodes.values()) {
            if(!nodeSet.contains(value)){
                nodeSet.add(value);
                for (Edge edge : value.edges) {
                    queue.add(edge);
                }
            }
            while (!queue.isEmpty()){
                Edge poll = queue.poll();
                Node to = poll.to;
                if(!nodeSet.contains(to)){
                    result.add(poll);
                    nodeSet.add(to);
                    for (Edge edge : to.edges) {
                        queue.add(edge);
                    }
                }
            }
            break;
        }
        return result;
    }
}
