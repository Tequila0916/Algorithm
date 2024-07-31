package org.tequila.system.class02;

/**
 * @ClassName Code02_EvenTimesOddTimes
 * @Description https://leetcode.cn/problems/single-number/
 *              https://leetcode.cn/problems/single-number-iii/
 * @Author GT-R
 * @Date 2023/7/1414:41
 * @Version 1.0
 */
public class Code02_EvenTimesOddTimes {
    // arr中，只有一种数，出现奇数次
    public void singleNumber(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    // arr中，有两种数，出现奇数次
    public void singleNumber_iii(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightOne = eor & (-eor); // 提取出最右的1
        int onlyOne = 0; // eor'
        for (int i = 0 ; i < arr.length;i++) {
            //  arr[1] =  111100011110000
            // rightOne=  000000000010000
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
