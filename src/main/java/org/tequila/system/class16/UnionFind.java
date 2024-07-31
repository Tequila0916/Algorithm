package org.tequila.system.class16;

import java.util.*;

/**
 * @ClassName UnionFind
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2213:53
 * @Version 1.0
 */
public class UnionFind<T> {
    HashMap<T, T> parent;
    HashMap<T, Integer> size;

    public UnionFind(Collection<T> list) {
        parent = new HashMap<>();
        size = new HashMap<>();
        for (T t : list) {
            parent.put(t, t);
            size.put(t, 1);
        }
    }

    public T findParent(T cur) {
        Stack<T> stack = new Stack();
        while (cur != parent.get(cur)) {
            stack.push(cur);
            cur = parent.get(cur);
        }
        while (!stack.isEmpty()) {
            parent.put(stack.pop(), cur);
        }
        return cur;
    }

    public boolean isSameSet(T o1, T o2) {
        return findParent(o1) == findParent(o2);
    }

    public void union(T a, T b) {
        T parentA = findParent(a);
        T parentB = findParent(b);
        if (parentA != parentB) {
            T big = size.get(parentA) > size.get(parentB) ? parentA : parentB;
            T small = big == parentA ? parentB : parentA;
            parent.put(small, big);
            size.put(big, size.get(big) + size.get(small));
            size.remove(small);
        }
    }

    public int sets() {
        return size.size();
    }
}
