package org.tequila.system.class16;

import java.util.*;

/**
 * @ClassName Code03_TopologySort
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2211:32
 * @Version 1.0
 */
public class Code03_TopologySort {
    public List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node value : graph.nodes.values()) {
            inMap.put(value, value.in);
            if (value.in == 0) {
                zeroInQueue.add(value);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node poll = zeroInQueue.poll();
            result.add(poll);
            for (Node next : poll.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
