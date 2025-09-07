package problem.p1xxx.p1304e;

import problem.UtilityClass;

import java.util.Arrays;

public class FindNUniqueIntSumUpToZero {
    public static void main(String[] args) {
        UtilityClass.logResult(Arrays.toString(sumZero(5)));
    }

    public static int[] sumZero(int n) {
        int[] ans = new int[n];
        int k = 0;
        for (int i = 1; i <= n/2; i++){
            ans[k++] = i;
            ans[k++] = -i;
        }

        if ((n & 1) == 1){
            ans[k] = 0;
        }
        return ans;
    }
}
