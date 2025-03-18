package problem.p2xxx.p2401m;

import problem.UtilityClass;

public class LongestNiceSubArray {
    public static int longestNiceSubarray(int[] nums) {
        // sliding windows
        int l = 0;
        int r = 1;
        int n = nums.length;
        int max = 0;
        int count = 1;

        while (r < n){
            if (canAssign(l, r, nums)){
                count++;
                r++;
            } else {
                max = Math.max(count, max);
                count= 1;
                l = l + 1;
                r = l + 1;
            }
        }
        return Math.max(count, max);
    }

    private static boolean canAssign(int l, int r, int[] nums) {
        for (int i = l; i < r; i++){
            for (int j = i + 1; j <= r; j++){
                if ((nums[i] & nums[j]) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int longestNiceSubarray2(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = 0;

        int maxWD = 0;
        int curSum = 0;
        int xorSum = 0;

        while (r < n){
            curSum += nums[r];
            xorSum ^= nums[r];

            while (curSum != xorSum){
                curSum -= nums[l];
                xorSum ^= nums[l];
                l++;
            }

            maxWD = Math.max(maxWD, r-l+1);
            r++;
        }

        return maxWD;
    }

    public static void main(String[] args) {
        int[] nums = {84139415,693324769,614626365,497710833,615598711,264,65552,50331652,1,1048576,16384,544,270532608,151813349,221976871,678178917,845710321,751376227,331656525,739558112,267703680};
        UtilityClass.logResult(longestNiceSubarray2(nums));
    }
}
