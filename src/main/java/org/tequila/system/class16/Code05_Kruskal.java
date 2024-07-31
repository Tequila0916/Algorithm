package org.tequila.system.class16;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName Code05_Kruskal
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2213:54
 * @Version 1.0
 */
public class Code05_Kruskal {
    public Set<Edge> kruskalMST(Graph graph) {
        UnionFind<Node> unionFind = new UnionFind(graph.nodes.values());
        PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            queue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (unionFind.sets() >= 1) {
            Edge poll = queue.poll();
            if (!unionFind.isSameSet(poll.from, poll.to)) {
                result.add(poll);
                unionFind.union(poll.from, poll.to);
            }
        }
        return result;
    }
}
