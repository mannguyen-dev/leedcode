package problem.p3xxx.p3363h;

import problem.UtilityClass;

import java.util.Arrays;
import java.util.List;

public class FindMaximumNumberOfFruits {

    private static final int INF = Integer.MAX_VALUE;
    private static int n;
    private static int[][] gfruits;
    private static int[][] memo;
    private static List<int[]> dirs;

    public static int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        gfruits = fruits;

        long first = 0;
        for (int i = 0; i < n; i++){
            first += gfruits[i][i];
        }

        dirs = Arrays.asList(new int[]{1, -1}, new int[]{1, 0}, new int[]{1, 1}); // down-left, down, down-right
        memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        int second = dfs(0, n - 1, n - 1);

        dirs = Arrays.asList(new int[]{-1, 1}, new int[]{0, 1}, new int[]{1, 1});
        memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        int third = dfs(n-1, 0, n - 1);

        return (int) (first + second + third);
    }

    private static int dfs(int row, int col, int moves) {
        if (row == n - 1 && col == n-1){
            return (moves == 0) ? 0 : INF;
        }

        if (moves == 0 || row == col){
            return INF;
        }

        if (memo[row][col] != -1){
            return memo[row][col];
        }
        long best = -1;
        for (int[] d : dirs){
            int nr = row + d[0];
            int nc = col + d[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n){
                int val = dfs (nr, nc, moves -1);
                if (val != INF){
                    best = Math.max(best, val);
                }
            }
        }
        int result = (best < 0 ? INF : gfruits[row][col] + (int) best);
        memo[row][col] = result;
        return result;

    }

    public static void main(String[] args) {
        int[][] fruits = new int[][]{{8,5,0,17,15},{6,0,15,6,0},{7,19,16,8,18},{11,3,2,12,13},{17,15,15,4,6}};
        UtilityClass.logResult(maxCollectedFruits(fruits));
    }
}
