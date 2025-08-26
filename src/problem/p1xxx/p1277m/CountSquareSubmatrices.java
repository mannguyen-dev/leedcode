package problem.p1xxx.p1277m;

import problem.UtilityClass;

public class CountSquareSubmatrices {
    public static int countSquares(int[][] matrix) {
        int subMatrixCount = 0;
        int n = matrix.length;
        int m =matrix[0].length;
        int[][] maxMatrix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (matrix[i-1][j-1] == 1){
                    maxMatrix[i][j] = 1 + Math.min(Math.min(maxMatrix[i-1][j], maxMatrix[i][j-1]), maxMatrix[i-1][j-1]);
                    subMatrixCount += maxMatrix[i][j];
                }
            }
        }
        return subMatrixCount;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,1},{1,1,0},{1,1,0}};
        UtilityClass.logResult(countSquares(matrix));
    }
}
