package org.tequila.system.class20;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName Code03_Coffee
 * @Description 题目
 * 数组arr代表每一个咖啡机冲一杯咖啡的时间，每个咖啡机只能串行的制造咖啡。
 * 现在有n个人需要喝咖啡，只能用咖啡机来制造咖啡。
 * 认为每个人喝咖啡的时间非常短，冲好的时间即是喝完的时间。
 * 每个人喝完之后咖啡杯可以选择洗或者自然挥发干净，只有一台洗咖啡杯的机器，只能串行的洗咖啡杯。
 * 洗杯子的机器洗完一个杯子时间为a，任何一个杯子自然挥发干净的时间为b。
 * 四个参数：arr, n, a, b
 * 假设时间点从0开始，返回所有人喝完咖啡并洗完咖啡杯的全部过程结束后，至少来到什么时间点。
 * @Author GT-R
 * @Date 2023/9/218:40
 * @Version 1.0
 */
public class Code03_Coffee {
    public int minTime1(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> heap = new PriorityQueue<>(new MachineComparator());
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            heap.add(new Machine(0, arr[i]));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Machine poll = heap.poll();
            poll.timePoint += poll.workTime;
            drinks[i] = poll.timePoint;
            heap.add(poll);
        }
        return bestTime(drinks, a, b, 0, 0);
    }

    /**
     *
     * @param drinks 所有杯子可以开始洗的时间
     * @param wash  单杯洗干净的时间
     * @param air   挥发干净的时间
     * @param index 几号杯子
     * @param free  洗的机器什么时候可用
     * @return  所有杯子变干净的最短时间
     */

    private int bestTime(int[] drinks, int wash, int air, int index, int free) {
        if (index == drinks.length) {
            return 0;
        }
        // index号杯子 决定洗
        int selfClean1 = Math.max(drinks[index], free) + wash;
        int restClean1 = bestTime(drinks, wash, air, index + 1, selfClean1);
        int p1 = Math.max(selfClean1, restClean1);

        // index号杯子 决定挥发
        int selfClean2 = drinks[index] + air;
        int restClean2 = bestTime(drinks, wash, air, index + 1, free);
        int p2 = Math.max(selfClean2, restClean2);
        return Math.min(p1, p2);
    }

    private int dp(int[] drinks, int wash, int air) {
        int maxFree = 0;
        int N = drinks.length;
        for (int i = 0; i < N; i++) {
            maxFree = Math.max(maxFree, drinks[i]) + wash;
        }
        int[][] dp = new int[N + 1][maxFree + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int free = 0; free <= maxFree; free++) {
                int selfClean1 = Math.max(drinks[index], free) + wash;
                if (selfClean1 > maxFree) {
                    continue;
                }
                int restClean1 = dp[index + 1][selfClean1];
                int p1 = Math.max(selfClean1, restClean1);
                int selfClean2 = drinks[index] + air;
                int restClean2 = dp[index + 1][free];
                int p2 = Math.max(selfClean2, restClean2);
                dp[index][free] = Math.min(p1, p2);
            }
        }
        return dp[0][0];
    }

    public int minTime2(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> heap = new PriorityQueue<>(new MachineComparator());
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            heap.add(new Machine(0, arr[i]));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Machine poll = heap.poll();
            poll.timePoint += poll.workTime;
            drinks[i] = poll.timePoint;
            heap.add(poll);
        }
        return dp(drinks, a, b);
    }

    @Test
    public void testCoffee() {
        int len = 10;
        int max = 10;
        int testTime = 10;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = Utils.randomArray(len, max);
            int n = (int) (Math.random() * 7) + 1;
            int a = (int) (Math.random() * 7) + 1;
            int b = (int) (Math.random() * 10) + 1;
            int ans1 = minTime1(arr, n, a, b);
            int ans2 = minTime2(arr, n, a, b);
            if (ans1 != ans2) {
                Utils.printArray(arr);
                System.out.println("n : " + n);
                System.out.println("a : " + a);
                System.out.println("b : " + b);
                System.out.println(ans1 + " , " + ans2);
                System.out.println("===============");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
