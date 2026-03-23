package Stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] { 2, 3 }));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int[] prev = stack.pop();
                max = Math.max(max, prev[1] * (i - prev[0]));
                start = prev[0];
            }
            stack.push(new int[] { start, heights[i] });
        }
        System.out.println(stack.size());
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            int[] prev = stack.pop();
            System.out.println(Arrays.toString(prev));
            max = Math.max(max, prev[1] * (heights.length - prev[0]));
        }
        return max;
    }
}
