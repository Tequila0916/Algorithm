package org.tequila.system.class32;

import org.junit.Test;

/**
 * @ClassName Code01_IndexTree
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/1708:56
 * @Version 1.0
 */
public class Code01_IndexTree {
    @Test
    public void testIndexTree() {
        int N = 100;
        int V = 100;
        int testTime = 2000000;
        IndexTree tree = new IndexTree(N);
        Right test = new Right(N);
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int index = (int) (Math.random() * N) + 1;
            if (Math.random() <= 0.5) {
                int add = (int) (Math.random() * V);
                tree.add(index, add);
                test.add(index, add);
            } else {
                if (tree.sum(index) != test.sum(index)) {
                    System.out.println("Oops!");
                }
            }
        }
        System.out.println("test finish");
    }
}
