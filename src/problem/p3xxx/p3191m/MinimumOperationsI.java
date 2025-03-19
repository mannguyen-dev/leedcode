package problem.p3xxx.p3191m;

import problem.UtilityClass;

public class MinimumOperationsI {
    public static int minOperations(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                flip(nums, i);
                flip(nums, i + 1);
                flip(nums, i + 2);
                res++;
            }
        }
        if (nums[n - 1] == 0 || nums[n - 2] == 0) {
            return -1;
        }

        return res;
    }

    private static void flip(int[] nums, int i) {
        nums[i] = nums[i] == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 0};
        UtilityClass.logResult(minOperations(nums));
    }
}
