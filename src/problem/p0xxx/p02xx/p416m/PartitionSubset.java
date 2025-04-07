package problem.p0xxx.p02xx.p416m;

import problem.UtilityClass;

public class PartitionSubset {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n: nums) sum += n;

        if ((sum & 1) != 0){
            return false;
        }

        return dfs(nums.length - 1, sum/2, nums );
    }

    private static boolean dfs(int index, int total, int[] nums){
        if (index < 0){
            return false;
        }

        if (total <= 0){
            return total == 0;
        }

        return dfs(index - 1, total, nums) || dfs(index - 1, total - nums[index], nums);
    }

    public static boolean canPartition2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        if ((sum & 1) != 0){
            return false;
        }

        // Dynamic programming
        int target = sum/2;
        boolean[][] subset = new boolean[n+1][target + 1];

        for (int i = 0; i <= n; i++) subset[i][0] = true;
        for (int i = 1; i <= target; i++) subset[0][i] = false;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= target; j++){
                if (j < nums[i-1]){
                    subset[i][j] = subset[i-1][j];
                } else {
                    subset[i][j] = subset[i-1][j] || subset[i-1][j-nums[i-1]];
                }
            }
        }

        return subset[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        UtilityClass.logResult(canPartition2(nums));
    }
}
