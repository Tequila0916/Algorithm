package org.tequila.novice.class01;

import org.junit.Test;

/**
 * @ClassName Code01_PrintBinary
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/408:32
 * @Version 1.0
 */
public class Code01_PrintBinary {
    public void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    @Test
    public void testPrint() {
        int num, a, b;
        num = Integer.MAX_VALUE;
        print(num);
        System.out.println("================================");
        a = 13579;
        b = 78898;
        print(a);
        print(b);
        System.out.println("================================");
        System.out.println("&运算");
        print(a & b);
        System.out.println("|运算");
        print(a | b);
        System.out.println("^运算");
        print(a ^ b);
        System.out.println("================================");
        a = -1024;
        System.out.println("原始数据：" + a);
        print(a);
        System.out.println("有符号右移：" + (a >> 1));
        print(a >> 1);
        System.out.println("无符号右移：" + (a >>> 1));
        print(a >>> 1);
        System.out.println("================================");
        b = -5;
        print(b);
        print(~b);
        print(~b + 1);
        System.out.println("================================");
        num = Integer.MIN_VALUE;
        print(num);
        print(~num);
        print(~num + 1);
        System.out.println("================================");
        num = 0;
        print(num);
        print(~num);
        print(~num + 1);

    }
}
