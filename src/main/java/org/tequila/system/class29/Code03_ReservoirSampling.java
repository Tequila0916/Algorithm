package org.tequila.system.class29;

import org.junit.Test;

/**
 * @ClassName Code03_ReservoirSampling
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/1108:37
 * @Version 1.0
 */
public class Code03_ReservoirSampling {
    public int random(int i){
        return (int)(Math.random()*i)+1;
    }
    @Test
    public void test(){
        int times = 1000000;
        int[] count = new int[1930];
        for (int i = 0; i < times; i++) {
            int[] bag = new int[10];
            int index = 0;
            for (int num = 1; num <= 1729; num++) {
                if(num<=10){
                    bag[index++] = num;
                }
                else {
                    if(random(num)<=10){
                        index = (int)(Math.random()*10);
                        bag[index] = num;
                    }
                }
            }
            for(int num:bag){
                count[num]++;
            }
        }
        for (int i = 0; i <=1729; i++) {
            System.out.println(count[i]);
        }
    }
}
