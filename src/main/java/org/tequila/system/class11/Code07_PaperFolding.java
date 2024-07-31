package org.tequila.system.class11;

import org.junit.Test;

/**
 * @ClassName Code07_PaperFolding
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/1111:49
 * @Version 1.0
 */
public class Code07_PaperFolding {
    public void printAllFolds(int N) {
        process(1, N, true);
    }

    public void process(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        process(i + 1, N, true);
        System.out.println(down ? "凹" : "凸");
        process(i + 1, N, false);
    }

    @Test
    public  void testPrintAllFolds(){
        int N = 4;
       printAllFolds(3);
    }
}
