package org.tequila.system.class16;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DirectedGraphNode
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2213:13
 * @Version 1.0
 */
public class DirectedGraphNode {
    int label;
    List<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
