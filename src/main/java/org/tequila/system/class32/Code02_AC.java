package org.tequila.system.class32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Code03_AC2
 * @Description TODO
 * @Author GT-R
 * @Date 2024/1/220:37
 * @Version 1.0
 */
public class Code02_AC {
    public static class Node {
        public String end;
        public boolean useEnd;
        public Node fail;
        public Node[] nexts;

        public Node() {
            end = null;
            useEnd = false;
            fail = null;
            nexts = new Node[26];
        }
    }

    public static class ACAutomation {
        private Node root;

        public ACAutomation() {
            root = new Node();
        }

        public void insert(String s) {
            char[] str = s.toCharArray();
            Node cur = root;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                if (cur.nexts[index] == null) {
                    cur.nexts[index] = new Node();
                }
                cur = cur.nexts[index];
            }
            cur.end = s;
        }

        public void build() {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            Node cur = null;
            Node cfail = null;
            while (!queue.isEmpty()) {
                cur = queue.poll();
                for (int i = 0; i < 26; i++) {
                    if (cur.nexts[i] != null) {
                        cur.nexts[i].fail = root;
                        cfail = cur.fail;
                        while (cfail != null) {
                            if (cfail.nexts[i] != null) {
                                cur.nexts[i].fail = cfail.nexts[i];
                                break;
                            }
                            cfail = cfail.fail;
                        }
                        queue.add(cur.nexts[i]);
                    }
                }
            }
        }

        public List<String> containWords(String content) {
            char[] str = content.toCharArray();
            Node cur = root;
            Node follow = null;
            int index = 0;
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                while (cur.nexts[index] == null && cur != root) {
                    cur = cur.fail;
                }
                cur = cur.nexts[index]!=null?cur.nexts[index]:root;
                follow = cur;
                while (follow!=root){
                    if(follow.useEnd){
                        break;
                    }
                    if(follow.end!=null){
                        ans.add(follow.end);
                        follow.useEnd=true;
                    }
                    follow = follow.fail;
                }
            }
            return ans;
        }
        public static void main(String[] args) {
            ACAutomation ac = new ACAutomation();
            ac.insert("dhe");
            ac.insert("he");
            ac.insert("abcdheks");
            // 设置fail指针
            ac.build();

            List<String> contains = ac.containWords("abcdhekskdjfafhasldkflskdjhwqaeruv");
            for (String word : contains) {
                System.out.println(word);
            }
        }
    }
}
