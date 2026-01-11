package problem.p0xxx.p00xx.p84h;

import problem.UtilityClass;

import java.util.Stack;

public class LargeRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>(); // pair: index, height
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++){
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, (i-index)*height);
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] pair: stack){
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height*(heights.length - index));
        }

        return maxArea;
    }

    public static void main() {
        int[] arr = {2,1,5,6,2,3};
        UtilityClass.logResult(largestRectangleArea(arr));
    }
}
