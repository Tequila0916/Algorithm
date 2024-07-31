package org.tequila.system.class15;

/**
 * @ClassName Code01_FriendCircles
 * @Description https://leetcode.cn/problems/number-of-provinces/
 * @Author GT-R
 * @Date 2023/8/2019:43
 * @Version 1.0
 */
public class Code01_FriendCircles {
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.sets();
    }


    public class UnionFind {
        private int[] parent;
        private int[] size;
        private int[] help;
        private int sets;

        public UnionFind(int N) {
            parent = new int[N];
            size = new int[N];
            help = new int[N];
            sets = N;
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int find(int i) {
            int index = 0;
            while (i != parent[i]) {
                help[index++] = i;
                i = parent[i];
            }
            for (index--; index >= 0; index--) {
                parent[help[index]] = i;
            }
            return i;
        }

        public void union(int i, int j) {
            int f1 = find(i);
            int f2 = find(j);
            if (f1 != f2) {
                if (size[f1] >= size[f2]) {
                    size[f1] += size[f2];
                    parent[f2] = f1;
                } else {
                    size[f2] += size[f1];
                    parent[f1] = f2;
                }
                sets--;
            }
        }

        public int sets() {
            return sets;
        }
    }
}
