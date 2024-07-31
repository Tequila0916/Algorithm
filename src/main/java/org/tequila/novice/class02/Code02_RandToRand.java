package org.tequila.novice.class02;


/**
 * @ClassName Code02_RandToRand
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/521:19
 * @Version 1.0
 */
public class Code02_RandToRand {
    // 等概率返回1~5
    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    public static void main(String[] args) {
        System.out.println("测试开始");

        int testTimes = 10000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.75) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("=========");

        // [0,1) -> [0,8)
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 5) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) 5 / (double) 8);

        int K = 9;
        int[] counts = new int[K];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * K);
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "这个数，出现了 " + counts[i] + " 次");
        }
        System.out.println("==========");
        count = 0;
        double x = 0.17;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((Math.pow(x, 2)));

        System.out.println("==========");

        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f4() == 1) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("==========");
    }

    private static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    public static int f2() {
        int ans;

        do {
            ans = f1();
        } while (ans == 3);

        return ans < 3 ? 0 : 1;
    }

    public static int f3() {
        return (f2() << 2) + (f2() << 1) + f2();
    }

    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    public static int g() {
        return f4() + 1;
    }

    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    public static int y() {
        int ans;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }
}
