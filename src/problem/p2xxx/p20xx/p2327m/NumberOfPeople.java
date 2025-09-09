package problem.p2xxx.p20xx.p2327m;

public class NumberOfPeople {
    private static final int MOD = 1_000_000_007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long winCount = 0;

        for (int curr = 2; curr <= n; ++curr) {
            if (curr - delay > 0) {
                winCount = (winCount + dp[curr - delay]) % MOD;
            }
            if (curr - forget > 0) {
                winCount = (winCount - dp[curr - forget] + MOD) % MOD;
            }
            dp[curr] = winCount;
        }

        long total = 0;
        for (int i = Math.max(1, n - forget + 1); i <= n; ++i) {
            total = (total + dp[i]) % MOD;
        }
        return (int) total;
    }
}
