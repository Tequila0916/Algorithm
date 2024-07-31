package org.tequila.system.class29;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @ClassName Code01_FindMinKth
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/820:43
 * @Version 1.0
 */
public class Code01_FindMinKth {
    public int minKth1(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.peek();
    }

    public int minKth2(int[] arr, int k) {
        int[] array = copyArray(arr);
        return process(array, 0, array.length - 1, k - 1);
    }

    public int process(int[] arr, int L, int R, int index) {
        if (L == R) {
            return arr[L];
        }
        int pivot = arr[L + (int) (Math.random() * (R - L + 1))];
        int[] range = partition(arr, L, R, pivot);
        if (index >= range[0] && index <= range[1]) {
            return arr[index];
        } else if (index < range[0]) {
            return process(arr, L, range[0], index);
        } else {
            return process(arr, range[1], R, index);
        }
    }

    public int[] partition(int[] arr, int l, int r, int pivot) {
        int less = l - 1;
        int more = r + 1;
        int cur = l;
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

    public int[] copyArray(int[] arr) {
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        return array;
    }

    public int minKth3(int[] arr, int K) {
        int[] ans = copyArray(arr);
        return bfprt(ans, 0, ans.length - 1, K - 1);
    }

    public int bfprt(int[] arr, int L, int R, int index) {
        if (L == R) {
            return arr[L];
        }
        int pivot = medianOfMedians(arr, L, R);
        int[] range = partition(arr, L, R, pivot);
        if (index < range[0]) {
            return bfprt(arr, L, range[0] - 1, index);
        } else if (index > range[1]) {
            return bfprt(arr, range[1] + 1, R, index);
        } else {
            return pivot;
        }
    }

    public int medianOfMedians(int[] arr, int l, int r) {
        int size = r - l + 1;
        int offset = size % 5 == 0 ? 0 : 1;
        int[] mArr = new int[size / 5 + offset];
        for (int team = 0; team < mArr.length; team++) {
            int teamFirst = l + team * 5;
            mArr[team] = getMedian(arr, teamFirst, Math.min(teamFirst + 4, r));
        }
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
//        return getMedian(mArr,0,mArr.length-1);
    }


    public int getMedian(int[] arr, int L, int R) {
        insertionSort(arr, L, R);
        return arr[(L + R) / 2];
    }

    public void insertionSort(int[] arr, int L, int R) {
        for (int i = L + 1; i <= R; i++) {
            for (int j = i - 1; j >= L && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    @Test
    public void testFindMinKth() {
        int testTime = 1000000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = Utils.generateRandomArray1(maxSize, maxValue);
            int k = (int) (Math.random() * arr.length) + 1;
            int ans1 = minKth1(arr, k);
            int ans2 = minKth3(arr, k);
            if (ans1 != ans2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }
}
