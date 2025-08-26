package problem.p3xxx.p3000e;

import problem.UtilityClass;

public class MaxAreaOfLongestDiagonalRectangle {

    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonalSq = 0;
        int maxArea = 0;

        for (int[] dimension : dimensions){
            int l = dimension[0];
            int w = dimension[1];
            int diaSq = l*l + w*w;
            int area = l*w;

            if (diaSq > maxDiagonalSq) {
                maxDiagonalSq = diaSq;
                maxArea = area;
            } else if (diaSq == maxDiagonalSq){
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] dimensions = {{9,3},{8,6}};
        UtilityClass.logResult(areaOfMaxDiagonal(dimensions));
    }
}
