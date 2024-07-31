package org.tequila.system.class40;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName Code02_LongestSumSubArrayLength
 * @Description TODO
 * @Author GT-R
 * @Date 2024/2/1219:06
 * @Version 1.0
 */
public class Code02_LongestSumSubArrayLength {
    public int maxLength(int[] arr, int k) {
        if(arr==null||arr.length==0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int window = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                window = Math.max(i-map.get(sum-k),window);
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return window;
    }

    // for test
    public int right(int[] arr, int K) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (valid(arr, i, j, K)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // for test
    public boolean valid(int[] arr, int L, int R, int K) {
        int sum = 0;
        for (int i = L; i <= R; i++) {
            sum += arr[i];
        }
        return sum == K;
    }

    // for test
    public int[] generateRandomArray(int size, int value) {
        int[] ans = new int[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * value) - (int) (Math.random() * value);
        }
        return ans;
    }

    // for test
    public void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        int len = 50;
        int value = 100;
        int testTime = 500000;

        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(len, value);
            int K = (int) (Math.random() * value) - (int) (Math.random() * value);
            int ans1 = maxLength(arr, K);
            int ans2 = right(arr, K);
            if (ans1 != ans2) {
                System.out.println("Oops!");
                printArray(arr);
                System.out.println("K : " + K);
                System.out.println(ans1);
                System.out.println(ans2);
                break;
            }
        }
        System.out.println("test end");

    }
}
