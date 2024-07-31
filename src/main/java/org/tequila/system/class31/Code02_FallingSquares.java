package org.tequila.system.class31;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName Code02_FallingSquares
 * @Description https://leetcode.cn/problems/falling-squares/
 * @Author GT-R
 * @Date 2023/12/1519:37
 * @Version 1.0
 */
public class Code02_FallingSquares {
    public class SegmentTree {
        private int[] max;
        private int[] change;
        private boolean[] update;

        public SegmentTree(int size) {
            int N = size + 1;
            max = new int[N << 2];
            change = new int[N << 2];
            update = new boolean[N << 2];
        }

        private void pushUp(int rt) {
            max[rt] = Math.max(max[rt << 1], max[rt << 1 | 1]);
        }

        private void pushDown(int rt) {
            if (update[rt]) {
                change[rt << 1] = change[rt];
                change[rt << 1 | 1] = change[rt];
                update[rt << 1] = true;
                update[rt << 1 | 1] = true;
                max[rt << 1] = change[rt];
                max[rt << 1 | 1] = change[rt];
                update[rt] = false;
            }
        }

        public void update(int L, int R, int C, int l, int r, int rt) {
            if (l >= L && r <= R) {
                update[rt] = true;
                change[rt] = C;
                max[rt] = C;
                return;
            }
            int mid = (l + r) >> 1;
            pushDown(rt);
            if (mid >= L) {
                update(L, R, C, l, mid, rt << 1);
            }
            if (mid < R) {
                update(L, R, C, mid + 1, r, rt << 1 | 1);
            }
            pushUp(rt);
        }

        public int query(int L, int R, int l, int r, int rt) {
            if (l >= L && r <= R) {
                return max[rt];
            }
            int mid = (l + r) >> 1;
            pushDown(rt);
            int left = 0;
            int right = 0;
            if (mid >= L) {
                left = query(L, R, l, mid, rt << 1);
            }
            if (mid < R) {
                right = query(L, R, mid + 1, r, rt << 1 | 1);
            }
            return Math.max(left, right);
        }
    }
    public HashMap<Integer, Integer> index(int[][] positions) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] position : positions) {
            set.add(position[0]);
            set.add(position[0]+position[1]-1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (Integer i : set) {
            map.put(i,++count);
        }
        return map;
    }

    public List<Integer> fallingSquares(int[][] positions) {
        HashMap<Integer,Integer> map = index(positions);
        int N = map.size();
        SegmentTree tree = new SegmentTree(N);
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for(int[] position:positions){
            int L = map.get(position[0]);
            int R = map.get(position[0]+position[1]-1);
            int height = tree.query(L,R,1,N,1)+position[1];
            max = Math.max(max,height);
            res.add(max);
            tree.update(L,R,height,1,N,1);
        }
        return res;
    }

    @Test
    public void test(){
        int[][] positions = new int[][]{{1,2},{2,3},{6,1}};
        List<Integer> integers = fallingSquares(positions);
        for (Integer integer : integers) {
            System.out.print(integer+" ");
        }
    }
}
