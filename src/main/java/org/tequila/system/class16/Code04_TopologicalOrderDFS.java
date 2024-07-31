package org.tequila.system.class16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @ClassName Code04_TopologicalOrderDFS
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2213:13
 * @Version 1.0
 */
public class Code04_TopologicalOrderDFS {
    public Record f(DirectedGraphNode cur, HashMap<DirectedGraphNode, Record> order) {
        if (order.containsKey(cur)) {
            return order.get(cur);
        }
        long nodes = 0;
        for (DirectedGraphNode neighbor : cur.neighbors) {
            nodes += f(neighbor, order).nodes;
        }
        Record record = new Record(cur, ++nodes);
        order.put(cur, record);
        return record;
    }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Record> order = new HashMap<>();
        for (DirectedGraphNode cur : graph) {
            f(cur, order);
        }
        ArrayList<Record> records = new ArrayList<>();
        for (Record value : order.values()) {
            records.add(value);
        }
        records.sort(new MyComparator());
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        for (Record record : records) {
            ans.add(record.node);
        }
        return ans;
    }

    public class MyComparator implements Comparator<Record> {

        @Override
        public int compare(Record o1, Record o2) {
            return o1.nodes == o2.nodes ? 0 : o1.nodes < o2.nodes ? 1 : -1;
        }
    }
}
