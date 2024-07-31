package org.tequila.system.class16;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 * @ClassName Code06_Dijkstra
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2215:37
 * @Version 1.0
 */
public class Code07_Dijkstra {
    public HashMap<Node, Integer> dijkstra(Node from) {
        HashMap<Node, Integer> result = new HashMap<>();
        result.put(from, 0);
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinNode(result, selectedNodes);
        while (minNode != null) {
            int distance = result.get(minNode);
            for (Edge edge : minNode.edges) {
                Node to = edge.to;
                if (!result.containsKey(to)) {
                    result.put(to, distance + edge.weight);
                } else {
                    result.put(to, Math.min(result.get(to), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinNode(result, selectedNodes);
        }
        return result;
    }

    private Node getMinNode(HashMap<Node, Integer> map, HashSet<Node> selectedNodes) {
        Node result = null;
        int max = Integer.MAX_VALUE;
        for (Entry<Node, Integer> entry : map.entrySet()) {
            Node key = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNodes.contains(key) && distance < max) {
                result = key;
                max = distance;
            }
        }
        return result;
    }

    @Test
    public void testdijkstra() {
        GraphGenerator generator = new GraphGenerator();
        int[][] matrix = {{1, 1, 2}, {6, 1, 3}, {4, 1, 4}, {5, 4, 5}, {1, 3, 5}, {4, 2, 5}, {1, 3, 4}, {2, 2, 3}};
        Graph graph = generator.createGraph(matrix);
        Node node = graph.nodes.get(1);
        HashMap<Node, Integer> dijkstra = dijkstra(node);
        System.out.println("dijkstra = " + dijkstra);
    }
}
