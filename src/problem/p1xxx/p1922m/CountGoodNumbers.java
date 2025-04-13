package problem.p1xxx.p1922m;

import problem.UtilityClass;

public class CountGoodNumbers {
    private static final int MOD = 1_000_000_007;
    public static int countGoodNumbers(long n) {
        return (int) ((myPow(4, n/2) * myPow(5, n-n/2)) % MOD);
    }

    public static long myPow(long x, long n) {
        long res = 1;

        while (n > 0){
            if ((n & 1) == 1){
                res = (int) ((res * x) % MOD);
            }
            n /= 2;
            x = (x * x) % MOD;
        }

        return res;
    }

    public static void main(String[] args) {
        long n = 50;
        UtilityClass.logResult(countGoodNumbers(n));
    }
}
