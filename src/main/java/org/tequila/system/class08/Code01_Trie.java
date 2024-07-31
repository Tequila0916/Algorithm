package org.tequila.system.class08;

/**
 * @ClassName Code01_Trie
 * @Description https://leetcode.cn/problems/implement-trie-ii-prefix-tree/
 * @Author GT-R
 * @Date 2023/8/209:03
 * @Version 1.0
 */
public class Code01_Trie {
    private Node root;

    public Code01_Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        Node node = root;
        node.pass++;
        int path = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            path = chars[i] - 'a';
            if (node.nexts[path] == null) {
                node.nexts[path] = new Node();
            }
            node = node.nexts[path];
            node.pass++;

        }
        node.end++;
    }

    public int search(String word) {
        if (word == null) {
            return 0;
        }
        int path = 0;
        Node node = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            path = chars[i] = 'a';
            if (node.nexts[path] == null) {
                return 0;
            }
            node = node.nexts[path];
        }
        return node.end;
    }

    public int startsWith(String pre) {
        if (pre == null) {
            return 0;
        }
        int path = 0;
        Node node = root;
        char[] chars = pre.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            path = chars[i] - 'a';
            if (node.nexts[path] == null) {
                return 0;
            }
            node = node.nexts[path];
        }
        return node.pass;
    }

    public void delete(String word) {
        if (search(word) != 0) {
            Node node = root;
            node.pass--;
            int path = 0;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (--node.nexts[path].pass == 0) {
                    node.nexts[path] = null;
                    return;
                }
                node = node.nexts[path];
            }
            node.end--;
        }
    }
}
