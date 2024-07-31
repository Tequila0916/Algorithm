package org.tequila.system.class25;

import java.util.Stack;

/**
 * @ClassName Code04_MaximalRectangle
 * @Description https://leetcode.cn/problems/maximal-rectangle/
 * @Author GT-R
 * @Date 2023/12/219:47
 * @Version 1.0
 */
public class Code04_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(largestRectangleArea(heights), maxArea);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int N = heights.length;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int pop = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (i - l - 1) * heights[pop]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            int l = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (N - l - 1) * heights[pop]);
        }
        return maxArea;
    }
}
