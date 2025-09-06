package problem.p3xxx.p3495h;

import problem.UtilityClass;

public class MinimumOperationsToMakeArray {
    public static long minOperations(int[][] queries) {
        long res = 0;
        for (int[] pair : queries){
            int l = pair[0];
            int r = pair[1];

            res += (getOperation(r) - getOperation(l - 1) + 1) / 2;
        }

        return res;
    }

    private static long getOperation(int n){
        long res = 0;
        long ops = 0;
        int powerOfFour = 1;
        while (powerOfFour <= n){
            int l = powerOfFour;
            int r = Math.min(n, powerOfFour * 4 - 1);
            ops += 1;
            res += (r - l + 1) * ops;
            powerOfFour *= 4;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] queries = {{1,2},{2,4}};
        UtilityClass.logResult(minOperations(queries));
    }
}
