package org.tequila.system.class17;

import java.util.HashMap;

/**
 * @ClassName NodeHeap
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2309:44
 * @Version 1.0
 */
public class NodeHeap {
    private Node[] nodes; // 实际的堆结构
    // key 某一个node， value 上面堆中的位置
    private HashMap<Node, Integer> heapIndexMap;
    // key 某一个节点， value 从源节点出发到该节点的目前最小距离
    private HashMap<Node, Integer> distanceMap;
    private int size; // 堆上有多少个点

    public NodeHeap(int size) {
        nodes = new Node[size];
        heapIndexMap = new HashMap<>();
        distanceMap = new HashMap<>();
        this.size = 0;
    }

    private boolean isEntered(Node node) {
        return heapIndexMap.containsKey(node);
    }

    private boolean inHeap(Node node) {
        return isEntered(node) && heapIndexMap.get(node) != -1;
    }

    private void insertHeapify(int index) {
        while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index, int size) {
        int left = (index * 2) + 1;
        while (left < size) {
            int small = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left]) ? left + 1 : left;
            small = distanceMap.get(nodes[small]) < distanceMap.get(nodes[index]) ? small : index;
            if (small == index) {
                break;
            }
            swap(small, index);
            index = small;
            left = (index * 2) + 1;
        }
    }

    private void swap(int one, int another) {
        heapIndexMap.put(nodes[one], another);
        heapIndexMap.put(nodes[another], one);
        Node tmp = nodes[one];
        nodes[one] = nodes[another];
        nodes[another] = tmp;
    }

    public void process(Node head, int distance) {
        if (inHeap(head)) {
            distanceMap.put(head, Math.min(distance, distanceMap.get(head)));
            insertHeapify(heapIndexMap.get(head));
        }
        if (!isEntered(head)) {
            nodes[size] = head;
            distanceMap.put(head, distance);
            heapIndexMap.put(head, size);
            insertHeapify(size++);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public NodeRecord pop() {
        NodeRecord result = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
        swap(0, size - 1);
        heapIndexMap.put(nodes[size - 1], -1);
        distanceMap.remove(nodes[size-1]);
        nodes[size - 1] = null;
        heapify(0, --size);
        return result;
    }
}
