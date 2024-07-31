package org.tequila.system.class01;

/**
 * @ClassName Code04_BSExist
 * @Description TODO
 * @Author GT-R
 * @Date 2023/7/1411:35
 * @Version 1.0
 */
public class Code04_BSExist {
    public boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int R = sortedArr.length - 1;
        int L = 0;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }
}
