package problem.p3xxx.p3742m;

import problem.UtilityClass;

import java.util.Arrays;

public class MaxPathScore {
    public static int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        // create dp
        int[][][] dp = new int[n][m][k+1];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        dp[0][0][0] = 0;

        //
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int c = 0; c <= k; c++){
                    if (dp[i][j][c] == -1) continue;

                    // go right
                    if (j + 1 < m){
                        int nc = grid[i][j+1] == 0 ? 0 : 1;
                        int nv = dp[i][j][c] + grid[i][j+1];
                        if (nc + c <= k) {
                            dp[i][j + 1][nc + c] = Math.max(dp[i][j + 1][nc + c], nv);
                        }
                    }

                    // go down
                    if (i + 1 < n){
                        int nc = grid[i+1][j] == 0 ? 0 : 1;
                        int nv = dp[i][j][c] + grid[i+1][j];
                        if (nc + c <= k) {
                            dp[i+1][j][nc + c] = Math.max(dp[i+1][j][nc + c], nv);
                        }
                    }
                }
            }
        }

        return Arrays.stream(dp[n-1][m-1]).max().getAsInt();
    }

    static void main() {
        int[][] grid = {{0,1,2},{1, 0, 2}, {2,0,0}};
        int k = 3;
        UtilityClass.logResult(maxPathScore(grid, k));
    }

}
