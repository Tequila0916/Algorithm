package org.tequila.system.class14;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Code05_UnionFind
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2015:15
 * @Version 1.0
 */

public class UnionFind<V> {
    public HashMap<V, V> father;
    public HashMap<V, Integer> size;

    public UnionFind(List<V> values) {
        father = new HashMap<>();
        size = new HashMap<>();
        for (V value : values) {
            father.put(value, value);
            size.put(value, 1);
        }
    }

    public V findFather(V cur) {
        Stack<V> stack = new Stack<>();
        while (cur != father.get(cur)) {
            stack.push(cur);
            cur = father.get(cur);
        }
        while (!stack.isEmpty()) {
            father.put(stack.pop(), cur);
        }
        return cur;
    }

    public boolean isSameSet(V a, V b) {
        return findFather(a) == findFather(b);
    }

    public void union(V a, V b) {
        V fatherA = findFather(a);
        V fatherB = findFather(b);
        if (fatherA != fatherB) {
            Integer sizeA = size.get(fatherA);
            Integer sizeB = size.get(fatherB);
            if (sizeA > sizeB) {
                father.put(fatherB, fatherA);
                size.put(fatherA, sizeA + sizeB);
                size.remove(fatherB);
            } else {
                father.put(fatherA, fatherB);
                size.put(fatherB, sizeB + sizeA);
                size.remove(fatherA);
            }
        }
    }

    public int sets() {
        return size.size();
    }
}

