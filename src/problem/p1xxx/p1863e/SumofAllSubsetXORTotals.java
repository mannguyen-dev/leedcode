package problem.p1xxx.p1863e;

import problem.UtilityClass;

public class SumofAllSubsetXORTotals {
    public static int subsetXORSum(int[] nums) {

        return dfs(0, 0, nums);
    }

    private static int dfs(int index, int sum, int[] nums) {
        int n = nums.length;
        if (index == n) return sum;
        return dfs(index + 1, sum ^ nums[index], nums)
                + dfs(index + 1, sum, nums);
    }

    public static int subsetXORSum2(int[] nums) {
        int res = 0;
        for (int num : nums) res |= num;
        return res << (nums.length - 1);
    }

    public static void main(String[] args) {

        int[] arr = {3,4,5,6,7,8};
        UtilityClass.logResult(subsetXORSum2(arr));
    }
}
