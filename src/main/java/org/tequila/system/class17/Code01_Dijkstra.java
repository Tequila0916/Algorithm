package org.tequila.system.class17;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName Code01_Dijkstra
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2308:17
 * @Version 1.0
 */
public class Code01_Dijkstra {
    public  HashMap<Node, Integer> dijkstra(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.process(head, 0);
        HashMap<Node,Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()){
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.process(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }
    @Test
    public void testdijkstra(){
        GraphGenerator generator = new GraphGenerator();
        int[][] matrix = {{1,1,2},{6,1,3},{4,1,4},{5,4,5},{1,3,5},{4,2,5},{1,3,4},{2,2,3}};
        Graph graph = generator.createGraph(matrix);
        Node node = graph.nodes.get(1);
        HashMap<Node, Integer> dijkstra = dijkstra(node, graph.nodes.size());
        System.out.println("dijkstra = " + dijkstra);
    }
}
