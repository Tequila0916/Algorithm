package org.tequila.system.class17;


/**
 * @ClassName GraphGenerator
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2309:36
 * @Version 1.0
 */
public class GraphGenerator {
    public Graph createGraph(int[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            int weight = matrix[i][0];
            int from = matrix[i][1];
            int to = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            fromNode.out++;
            toNode.in++;
            fromNode.nexts.add(toNode);
            Edge edge = new Edge(fromNode,toNode,weight);
            fromNode.edges.add(edge);
            graph.edges.add(edge);

        }
        return graph;
    }
}
