package problem.p2xxx.p20xx.p2033m;

import problem.UtilityClass;

import java.util.Arrays;

public class MinimumOperationsMakeUniValue {

    public static int minOperations(int[][] grid, int x) {
        // step 1: flat the grid
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = new int[m*n];
        int reminder = grid[0][0] % x;
        for (int i = 0; i< n; i++){
            for (int j = 0; j< m; j++){
                if (grid[i][j] % x != reminder){
                    return -1;
                }
                arr[i*m+j] = grid[i][j];
            }
        }
        // Step 2: sort the arr
        Arrays.sort(arr);
        int median = m*n/2;

        // Step 3: count steps
        int steps = 0;
        for (int i = 0; i < m*n; i++){
            steps += Math.abs(arr[i] - arr[median])/x;
        }
        return steps;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,4},{6,8}};
        int x = 2;
        UtilityClass.logResult(minOperations(grid, x));
    }
}
