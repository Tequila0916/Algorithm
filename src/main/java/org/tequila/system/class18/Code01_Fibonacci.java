package org.tequila.system.class18;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName Code01_Fibonacci
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2408:45
 * @Version 1.0
 */
public class Code01_Fibonacci {
    HashMap<Integer,Integer> result = new HashMap<>();
    public int fibonacciSequence(int N){
        if(N==1){
            return 1;
        }
        if(N==2){
            return 1;
        }
        return fibonacciSequence(N-1)+fibonacciSequence(N-2);
    }
    @Test
    public void testFibonacci(){
        int result = fibonacciSequence(6);
        System.out.println("result = " + result);
    }
}
