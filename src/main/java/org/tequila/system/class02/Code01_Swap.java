package org.tequila.system.class02;

/**
 * @ClassName Code01_Swap
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1413:43
 * @Version 1.0
 */
public class Code01_Swap {
    public void swap(int[] arr, int i, int j) {
        // arr[0] = arr[0] ^ arr[0];
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
