package org.tequila.system.class08;

/**
 * @ClassName Node
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/209:01
 * @Version 1.0
 */
public class Node {
    public int pass;
    public int end;
    public Node[] nexts;

    public Node() {
        pass = 0;
        end = 0;
        nexts = new Node[26];
    }
}
