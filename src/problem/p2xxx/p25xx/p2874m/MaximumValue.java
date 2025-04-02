package problem.p2xxx.p25xx.p2874m;

import problem.UtilityClass;

public class MaximumValue {
    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        // Step 1: Find right max for all indices
        int maxVal = nums[n-1];
        for (int i = n-2; i > 0;i--){
            rightMax[i] = maxVal;
            maxVal = Math.max(maxVal, nums[i]);
        }

        // Step 2: find the max triplet
        long maxTriplet = 0;
        maxVal = nums[0];
        for (int i = 1; i < n; i++){
            maxTriplet = Math.max(maxTriplet, (long) (maxVal - nums[i]) *rightMax[i]);
            maxVal = Math.max(nums[i], maxVal);
        }
        return maxTriplet;
    }

    public static long maximumTripletValue2(int[] nums) {
        long maxDiff = 0;
        long maxLeft = 0;
        long maxTriplet = 0;
        for (int num : nums) {
            maxTriplet = Math.max(maxTriplet, maxDiff * num);
            maxDiff = Math.max(maxDiff, maxLeft - num);
            maxLeft = Math.max(maxLeft, num);
        }

        return maxTriplet;
    }

    public static void main(String[] args) {
        int[] nums = {12,6,1,2,7};
        UtilityClass.logResult(maximumTripletValue2(nums));
    }
}
