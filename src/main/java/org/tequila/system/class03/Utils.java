package org.tequila.system.class03;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1717:31
 * @Version 1.0
 */
public class Utils {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        int pop = myQueue.pop();
        System.out.println(pop);
        pop = myQueue.pop();
        System.out.println(pop);
        myQueue.push(6);
        pop = myQueue.pop();
        System.out.println(pop);
        pop = myQueue.pop();
        System.out.println(pop);
        pop = myQueue.pop();
        System.out.println(pop);
        System.out.println(myQueue.isEmpty());
    }
}
