package problem.p2xxx.p25xx.p2873e;

import problem.UtilityClass;

public class MaximumValue {
    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max = 0;
        for (int i = 0; i < n-2; i++){
            for (int j = i+1; j < n-1; j++){
                for (int k = j+1; k < n; k++){
                    long calc = (long) (nums[i] - nums[j]) *nums[k];
                    if (max < calc){
                        max = calc;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {12,6,1,2,7};
        UtilityClass.logResult(maximumTripletValue(nums));
    }
}
