package org.tequila.system.class25;


/**
 * @ClassName Code05_CountSubmatricesWithAllOnes
 * @Description https://leetcode.cn/problems/count-submatrices-with-all-ones/
 * @Author GT-R
 * @Date 2023/12/220:09
 * @Version 1.0
 */
public class Code05_CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        if (mat == null || mat.length < 1 || mat[0].length < 1) {
            return 0;
        }
        int nums = 0;
        int[] height = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
            }
            nums += countFromBottom(height);
        }
        return nums;
    }

    private int countFromBottom(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int result = 0;
        int N = height.length;
        int[] stack = new int[N];
        int p = -1;
        for (int i = 0; i < N; i++) {
            while (p != -1 && height[stack[p]] >= height[i]) {
                int pop = stack[p--];
                if (height[i] == height[pop]) {
                    break;
                }
                int left = p == -1 ? -1 : stack[p];
                int max = Math.max(left == -1 ? 0 : height[left], height[i]);
                result += num(i - left - 1) * (height[pop] - max);
            }
            stack[++p] = i;
        }
        while (p != -1) {
            int pop = stack[p--];
            int left = p == -1 ? -1 : stack[p];
            int max = left == -1 ? 0 : height[left];
            result += num(N - left - 1) * (height[pop] - max);
        }
        return result;
    }

    public int num(int n) {
        return ((n * (1 + n)) >> 1);
    }

}
