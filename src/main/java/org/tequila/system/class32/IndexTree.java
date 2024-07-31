package org.tequila.system.class32;

/**
 * @ClassName IndexTree
 * @Description TODO
 * @Author GT-R
 * @Date 2024/1/209:49
 * @Version 1.0
 */
public class IndexTree {
    private int[] tree;
    private int N;

    // 0位置弃而不用！
    public IndexTree(int size) {
        N = size;
        tree = new int[N + 1];
    }
    public int sum(int index) {
        int ret = 0;
        while (index>0){
            ret += tree[index];
            index -= index & -index;
        }
        return ret;
    }

    public void add(int index, int d) {
        while (index <= N) {
            tree[index] += d;
            index += index & -index;
        }
    }
}
