package org.tequila.system.class25;

import java.util.Stack;

/**
 * @ClassName Code03_LargestRectangleInHistogram
 * @Description https://leetcode.cn/problems/largest-rectangle-in-histogram
 * @Author GT-R
 * @Date 2023/12/219:32
 * @Version 1.0
 */
public class Code03_LargestRectangleInHistogram {
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
        while (!stack.isEmpty()){
            int pop = stack.pop();
            int l = stack.isEmpty()? -1:stack.peek();
            maxArea = Math.max(maxArea,(N-l-1)*heights[pop]);
        }
        return maxArea;
    }
}
