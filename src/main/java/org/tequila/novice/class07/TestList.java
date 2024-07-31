package org.tequila.novice.class07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName TestList
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1109:57
 * @Version 1.0
 */
public class TestList {
    public static void main(String[] args) {
        int testTimes = 100000;
        long start;
        long end;


        List<Integer> arr1 = new ArrayList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            arr1.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("arr1.size() = " + arr1.size());
        System.out.println("==========");


        List<Integer> arr2 = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            arr2.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("arr2.size() = " + arr2.size());
        System.out.println("==========");


        testTimes = 10000000;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < testTimes; i++) {
            stack.add(i);
        }
        start = System.currentTimeMillis();
        while (!stack.isEmpty()){
            stack.pop();
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("stack.size() = " + stack.size());
        System.out.println("==========");


        LinkedList<Integer> list= new LinkedList<>();
        for (int i = 0; i < testTimes; i++) {
            list.addLast(i);
        }
        start = System.currentTimeMillis();
        while (!list.isEmpty()){
            list.pollLast();
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("list.size() = " + list.size());
        System.out.println("==========");

        int[] arr3 = new int[testTimes];
        int index = 0;
        for (int i = 0; i < testTimes; i++) {
            arr3[index++] = i;
        }
        start = System.currentTimeMillis();
        while (index!=0){
            int pop = arr3[--index];
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("arr3.size() = " + arr3.length);
    }
}
