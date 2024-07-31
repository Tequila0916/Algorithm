package org.tequila.system.class27;

import org.junit.Test;

/**
 * @ClassName Code03_IsRotation
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/716:14
 * @Version 1.0
 */
public class Code03_IsRotation {

    public boolean isRotation(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        String temp = b + b;
        return -1 != getIndexOf(temp, a);
    }

    // KMP Algorithm
    public int getIndexOf(String s, String m) {
        if (s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int x = 0;
        int y = 0;
        int[] next = getNextArray(ms);
        while (x < ss.length && y < ms.length) {
            if (ss[x] == ms[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == ms.length ? x - y : -1;
    }

    public int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < ms.length) {
            if (ms[cn] == ms[pos - 1]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    @Test
    public void testIsRotation() {
        String str1 = "yunzuochen";
        String str2 = "zuochenyun";
        System.out.println(isRotation(str1, str2));

    }
}
