package org.tequila.system.class16;

import java.util.Comparator;

/**
 * @ClassName EdgeComparator
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2214:47
 * @Version 1.0
 */
public class EdgeComparator implements Comparator<Edge> {
    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
    }
}
