package org.tequila.system.class06;

/**
 * @ClassName MyMaxHeap
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/2814:44
 * @Version 1.0
 */
public class MyMaxHeap {
    private final int limit;
    private int[] arr;
    private int heapSize;

    public MyMaxHeap(int limit) {
        heapSize = 0;
        this.limit = limit;
        arr = new int[limit];
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public void push(int value) {
        if (limit == heapSize) {
            throw new RuntimeException("heap is full");
        }
        arr[heapSize] = value;
        heapInsert(arr, heapSize++);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        int result = arr[0];
        swap(arr, 0, --heapSize);
        heapify(arr, 0, heapSize);
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        return arr[0];
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int changed = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            changed = arr[changed] > arr[index] ? changed : index;
            if (changed == index) {
                break;
            }
            swap(arr, index, changed);
            index = changed;
            left = index * 2 + 1;
        }
    }
}
