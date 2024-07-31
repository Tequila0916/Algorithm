package org.tequila.system.class16;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Code01_BFS
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2209:57
 * @Version 1.0
 */
public class Code01_BFS {
    public  void bfs(Node start) {
        if(start==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> hashSet = new HashSet<>();
        queue.add(start);
        hashSet.add(start);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            for (Node next : poll.nexts) {
                if(!hashSet.contains(next)){
                    queue.add(next);
                    hashSet.add(next);
                }
            }
        }
    }
}
