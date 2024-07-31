package org.tequila.system.class03;

/**
 * @ClassName Code05_MyStack
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1716:55
 * @Version 1.0
 */


public class MyQueue {
    private int[] arr;
    private int pushi;// end
    private int polli;// begin
    private int size;
    private int limit;

    public MyQueue(int limit) {
        arr = new int[limit];
        size = 0;
        pushi = 0;
        polli = 0;
        this.limit = limit;
    }

    public void push(int value) {
        if (size==limit) {
            throw new RuntimeException("队列满了，不能再加了");
        }
        size++;
        arr[pushi] = value;
        pushi = nextIndex(pushi);
    }

    public int pop() {
        if (size==0) {
            throw new RuntimeException("队列空了，不能再拿了");
        }
        size--;
        int ans = arr[polli];
        polli = nextIndex(polli);
       return ans;
    }

    public boolean isEmpty() {
        return size==0;
    }
    private int nextIndex(int i) {
        return i < limit - 1 ? i + 1 : 0;
    }

}


