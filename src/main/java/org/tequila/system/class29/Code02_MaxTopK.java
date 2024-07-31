package org.tequila.system.class29;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Code02_MaxTopK
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/911:54
 * @Version 1.0
 */
public class Code02_MaxTopK {
    public int[] maxTopK1(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int N = arr.length;
        k = Math.min(N, k);
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[--N];
        }
        return ans;
    }

    public int[] maxTopK2(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int N = arr.length;
        k = Math.min(N, k);
        int num = minKth(arr, N - k);
        int[] ans = new int[k];
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > num) {
                ans[index++] = arr[i];
            }
        }
        for (; index < k; index++) {
            ans[index] = num;
        }
        Arrays.sort(ans);
        for (int L = 0, R = ans.length - 1; L < R; L++, R--) {
            swap(ans, L, R);
        }
        return ans;
    }

    public int minKth(int[] arr, int index) {
        int L = 0;
        int R = arr.length - 1;
        int pivot = 0;
        int[] range = null;
        while (L < R) {
            pivot = arr[L + (int) ((R - L + 1) * Math.random())];
            range = partition(arr, L, R, pivot);
            if (index < range[0]) {
                R = range[0] - 1;
            } else if (index > range[1]) {
                L = range[1] + 1;
            } else {
                return pivot;
            }
        }
        return arr[L];
    }

    public int[] partition(int[] arr, int L, int R, int pivot) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < pivot) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > pivot) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] maxTopK3(int[] arr, int k) {
        if (arr == null || arr.length < 1) {
            return new int[0];
        }
        int N = arr.length;
        k = Math.min(k, N);
        for (int i = N - 1; i >= 0; i--) {
            heapify(arr, i, N);
        }
//        for (int i = 0; i < N; i++) {
//            heapInsert(arr, i);
//        }
        int heapSize = N;
        swap(arr, 0, --heapSize);
        int count = 1;
        while (heapSize > 0 && count < k) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
            count++;
        }
        int[] ans = new int[k];
        for (int i = 0, j = N - 1; i < k; i++, j--) {
            ans[i] = arr[j];
        }
        return ans;
    }

    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int target = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            target = arr[target] > arr[index] ? target : index;
            if (target == index) {
                break;
            }
            swap(arr, target, index);
            index = target;
            left = 2 * index + 1;
        }
    }

    @Test
    public void testMaxTopK() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean pass = true;
        System.out.println("测试开始，没有打印出错信息说明测试通过");
        for (int i = 0; i < testTime; i++) {
            int k = (int) (Math.random() * maxSize) + 1;
            int[] arr = Utils.generateRandomArray2(maxSize, maxValue);
            int[] arr1 = Utils.copyArray(arr);
            int[] arr2 = Utils.copyArray(arr);
            int[] ans1 = maxTopK1(arr1, k);
            int[] ans2 = maxTopK3(arr2, k);
            if (!Utils.isEqual(ans1, ans2)) {
                pass = false;
                System.out.println("出错了！");
                Utils.printArray(ans1);
                Utils.printArray(ans2);
                break;
            }
        }
        System.out.println("测试结束了，测试了" + testTime + "组，是否所有测试用例都通过？" + (pass ? "是" : "否"));
    }

}
