package org.tequila.system.class40;

import org.junit.Test;

/**
 * @ClassName Code01_LongestSumSubArrayLengthInPositiveArray
 * @Description TODO
 * @Author GT-R
 * @Date 2024/2/1218:52
 * @Version 1.0
 */
public class Code01_LongestSumSubArrayLengthInPositiveArray {
    public int getMaxLength(int[] arr, int K) {
        if (arr == null || arr.length == 0 || K < 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int sum = arr[0];
        int window = 0;
        while (r < arr.length) {
            if(sum<K){
                r++;
                if(r==arr.length){
                    break;
                }
                sum+=arr[r];
            }
            else if(sum==K){
                window = Math.max(window,r-l+1);
                r++;
                if(r==arr.length){
                    break;
                }
                sum+=arr[r];
            }
            else if(sum>K){
                sum -= arr[l++];
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
    public int[] generatePositiveArray(int size, int value) {
        int[] ans = new int[size];
        for (int i = 0; i != size; i++) {
            ans[i] = (int) (Math.random() * (value+1));
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
            int[] arr = generatePositiveArray(len, value);
            int K = (int) (Math.random() * value) + 1;
            int ans1 = getMaxLength(arr, K);
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
