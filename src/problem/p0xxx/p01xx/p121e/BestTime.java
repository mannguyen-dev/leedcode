package problem.p0xxx.p01xx.p121e;

import problem.UtilityClass;

public class BestTime {
    public static int maxProfit(int[] prices) {
        int maxDiff = 0;
        int minLeft = prices[0];
        for (int num : prices){
            maxDiff = Math.max(maxDiff, num - minLeft);
            minLeft = Math.min(minLeft, num);
        }
        return maxDiff;
    }

    public static void main(String[] args) {

        int[] arr = {7,1,5,3,6,4};
        UtilityClass.logResult(maxProfit(arr));
    }
}
