package org.tequila.system.class15;

/**
 * @ClassName Code02_NumberOfIslands
 * @Description https://leetcode.cn/problems/number-of-islands/
 * @Author GT-R
 * @Date 2023/8/2020:32
 * @Version 1.0
 */
public class Code02_NumberOfIslands {
    public int numIslands(char[][] board) {
        int islands = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    islands++;
                    infect(board, i, j);
                }
            }
        }
        return islands;
    }

    private void infect(char[][] board, int i, int j) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != '1') {
            return;
        }
        board[i][j] = 0;
        infect(board, i - 1, j);
        infect(board, i + 1, j);
        infect(board, i, j - 1);
        infect(board, i, j + 1);
    }


    public int numIslands2(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        UnionFind uf = new UnionFind(board);
        for (int j = 1; j < col; j++) {
            if (board[0][j - 1] == '1' && board[0][j] == '1') {
                uf.union(0, j - 1, 0, j);
            }
        }
        for (int i = 1; i < row; i++) {
            if (board[i - 1][0] == '1' && board[i][0] == '1') {
                uf.union(i - 1, 0, i, 0);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == '1') {
                    if (board[i][j - 1] == '1') {
                        uf.union(i, j - 1, i, j);
                    }
                    if (board[i - 1][j] == '1') {
                        uf.union(i - 1, j, i, j);
                    }
                }
            }
        }
        return uf.sets();
    }

    public class UnionFind {
        private int[] parent;
        private int[] size;
        private int[] help;
        private int sets;
        private int column;

        public UnionFind(char[][] board) {
            int row = board.length;
            column = board[0].length;
            sets = 0;
            int len = row * column;
            parent = new int[len];
            size = new int[len];
            help = new int[len];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (board[i][j] == '1') {
                        int index = index(i, j);
                        parent[index] = index;
                        size[index] = 1;
                        sets++;
                    }
                }
            }
        }

        private int index(int r, int c) {
            return r * column + c;
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

        public void union(int r1, int c1, int r2, int c2) {
            int i1 = index(r1, c1);
            int i2 = index(r2, c2);
            int f1 = find(i1);
            int f2 = find(i2);
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
