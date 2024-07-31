package org.tequila.system.class16;

import java.util.HashSet;
import java.util.Stack;

/**
 * @ClassName Code02_DFS
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2210:02
 * @Version 1.0
 */
public class Code02_DFS {
    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> hashSet = new HashSet<>();
        hashSet.add(node);
        stack.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            for (Node next : pop.nexts) {
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    stack.push(pop);
                    stack.push(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }

    }
}
