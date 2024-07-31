package org.tequila.system.class07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName HeapGreater
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/114:32
 * @Version 1.0
 */
public class HeapGreater<T> {
    private ArrayList<T> heap;
    private HashMap<T, Integer> indexMap;
    private int heapSize;
    private Comparator<T> comp;

    public HeapGreater(Comparator<T> comp) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        this.comp = comp;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }

    public T peek() {
        return heap.get(0);
    }

    public void push(T obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        heapInsert(heapSize++);

    }

    public T pop() {
        T result = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(result);
        heap.remove(--heapSize);
        heapify(0);
        return result;
    }

    public void remove(T obj) {
        T replace = heap.get(heapSize - 1);
        int index = indexMap.get(obj);
        indexMap.remove(obj);
        heap.remove(--heapSize);
        if (obj != replace) {
            heap.set(index, replace);
            indexMap.put(replace, index);
            resign(replace);
        }
    }

    public List<T> getAllElements() {
        List<T> ans = new ArrayList<>();
        for (T c : heap) {
            ans.add(c);
        }
        return ans;
    }

    public void resign(T obj) {
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }

    private void heapInsert(int size) {
        while (comp.compare(heap.get(size), heap.get((size - 1) / 2)) < 0) {
            swap(size, (size - 1) / 2);
            size = (size - 1) / 2;
        }
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int changed = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(left)) < 0 ? left + 1 : left;
            changed = comp.compare(heap.get(changed), heap.get(index)) < 0 ? changed : index;
            if (index == changed) {
                break;
            }
            swap(changed, index);
            index = changed;
            left = index * 2 + 1;
        }
    }

    private void swap(int a, int b) {
        T i = heap.get(a);
        T j = heap.get(b);
        heap.set(a, j);
        heap.set(b, i);
        indexMap.put(i, b);
        indexMap.put(j, a);
    }

}
