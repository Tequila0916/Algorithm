package org.tequila.system.class17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Code04_PrintAllPermutations
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2314:13
 * @Version 1.0
 */
public class Code04_PrintAllPermutations {
    public List<String> permutation1(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return ans;
        }
        char[] str = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : str) {
            list.add(c);
        }
        String path = "";
        f(list, path, ans);
        return ans;
    }

    /**
     *
     * @param list 剩下的字符
     * @param path 之前做过的决定
     * @param ans
     */

    private void f(List<Character> list, String path, List<String> ans) {
        if (list.isEmpty()) {
            ans.add(path);
        } else {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Character remove = list.remove(i);
                f(list, path + remove, ans);
                list.add(i, remove);
            }
        }
    }

    public List<String> permutation2(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] str = s.toCharArray();
        g(str, 0, ans);
        return ans;
    }

    private void g(char[] str, int index, List<String> ans) {
        if (index == str.length) {
            ans.add(String.valueOf(str));
        } else {
            int length = str.length;
            for (int i = index; i < length; i++) {
                swap(str, index, i);
                g(str, index + 1, ans);
                swap(str, index, i);
            }
        }
    }

    private void swap(char[] str, int one, int another) {
        char temp = str[one];
        str[one] = str[another];
        str[another] = temp;
    }


    public List<String> permutation3(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] str = s.toCharArray();
        h(str, 0, ans);
        return ans;
    }

    private void h(char[] str, int index, List<String> ans) {
        if (index == str.length) {
            ans.add(String.valueOf(str));
        } else {
            boolean[] flag = new boolean[256];
            int length = str.length;
            for (int i = index; i < length; i++) {
                if (!flag[str[i]]) {
                    flag[str[i]] = true;
                    swap(str, index, i);
                    h(str, index + 1, ans);
                    swap(str, index, i);
                }
            }
        }
    }

    @Test
    public void testPermutation() {
        List<String> abcd = permutation3("accc");
        System.out.println("abcd.size() = " + abcd.size());
        System.out.println("abcd = " + abcd);
    }
}
