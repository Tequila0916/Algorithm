package org.tequila.system.class31;

/**
 * @ClassName SegmentTree
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/1511:19
 * @Version 1.0
 */
public class SegmentTree {
    private int MAXN;
    private int[] arr;
    private int[] sum;
    private int[] lazy;
    private int[] change;
    private boolean[] update;

    public SegmentTree(int[] origin) {
        MAXN = origin.length + 1;
        arr = new int[MAXN];
        for (int i = 1; i < MAXN; i++) {
            arr[i] = origin[i - 1];
        }
        sum = new int[MAXN << 2];
        lazy = new int[MAXN << 2];
        change = new int[MAXN << 2];
        update = new boolean[MAXN << 2];
    }

    private void pushUp(int rt) {
        sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
    }

    public void build(int l, int r, int rt) {
        if (l == r) {
            sum[rt] = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(l, mid, rt << 1);
        build(mid + 1, r, rt << 1 | 1);
        pushUp(rt);
    }

    public void add(int L, int R, int C, int l, int r, int rt) {
        if (L <= l && R >= r) {
            sum[rt] += C * (r - l + 1);
            lazy[rt] += C;
            return;
        }
        int mid = (l + r) >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        if (L <= mid) {
            add(L, R, C, l, mid, rt << 1);
        }
        if (R > mid) {
            add(L, R, C, mid + 1, r, rt << 1 | 1);
        }
        pushUp(rt);
    }

    public void update(int L, int R, int C, int l, int r, int rt) {
        if (L <= l && R >= r) {
            update[rt] = true;
            change[rt] = C;
            sum[rt] = C * (r - l + 1);
            lazy[rt] = 0;
            return;
        }
        int mid = (l + r) >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        if (L <= mid) {
            update(L, R, C, l, mid, rt << 1);
        }
        if (R > mid) {
            update(L, R, C, mid + 1, r, rt << 1 | 1);
        }
        pushUp(rt);
    }

    public long query(int L, int R, int l, int r, int rt) {
        if (L <= l && R >= r) {
            return sum[rt];
        }
        int mid = (l + r) >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        long ans = 0;
        if (L <= mid) {
            ans += query(L, R, l, mid, rt << 1);
        }
        if (R > mid) {
            ans += query(L, R, mid + 1, r, rt << 1 | 1);
        }
        return ans;
    }

    private void pushDown(int rt, int ln, int rn) {
        if (update[rt]) {
            change[rt << 1] = change[rt];
            change[rt << 1 | 1] = change[rt];
            update[rt << 1] = true;
            update[rt << 1 | 1] = true;
            sum[rt << 1] = ln * change[rt];
            sum[rt << 1 | 1] = rn * change[rt];
            lazy[rt << 1] = 0;
            lazy[rt << 1 | 1] = 0;
            update[rt] = false;

        }
        if (lazy[rt] != 0) {
            lazy[rt << 1] += lazy[rt];
            sum[rt << 1] += lazy[rt] * ln;
            lazy[rt << 1 | 1] += lazy[rt];
            sum[rt << 1 | 1] += lazy[rt] * rn;
            lazy[rt] = 0;
        }
    }
}
