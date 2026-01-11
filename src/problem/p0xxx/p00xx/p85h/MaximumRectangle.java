package problem.p0xxx.p00xx.p85h;

import problem.UtilityClass;

import java.util.Arrays;
import java.util.Stack;

public class MaximumRectangle {
    static void main() {
//        int[] arr = {2,1,5,6,2,3};
//        UtilityClass.logResult(largestRectangleArea(arr));
        char[][] matrix = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        UtilityClass.logResult(maximalRectangle(matrix));

    }

    public static int maximalRectangle(char[][] matrix) {
        int maxRectangle = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] histogram = new int[m];
        Arrays.fill(histogram, 0);

        for (char[] line : matrix){
            // make histogram
            for (int i = 0; i < m; i++){
                if (line[i] == '0'){
                    histogram[i] = 0;
                } else {
                    histogram[i]++;
                }
            }

            // calc max area and compare with maxRec
            maxRectangle = Math.max(maxRectangle, largestRectangleArea(histogram));
        }

        return maxRectangle;
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++){
            int start = i;

            while (!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height*(i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] pair : stack){
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }
}
