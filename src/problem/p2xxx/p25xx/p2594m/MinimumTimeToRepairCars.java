package problem.p2xxx.p25xx.p2594m;

import problem.UtilityClass;

public class MinimumTimeToRepairCars {

    public static long repairCars(int[] ranks, int cars) {
        long l = 1;
        long r = ranks[0] * (long) cars * cars;
        long res = r;

        while (l <= r){
            long mid = l + (r-l)/2;
            long count = 0;
            for (int rank : ranks) {
                count += (long) Math.sqrt((double) mid / rank); // r * n * n = mid <=> n*n = mid/r
            }

            if (count >= cars){
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] ranks = {4,2,3,1};
        int cars = 10;
        UtilityClass.logResult(repairCars(ranks, cars));
    }
}
