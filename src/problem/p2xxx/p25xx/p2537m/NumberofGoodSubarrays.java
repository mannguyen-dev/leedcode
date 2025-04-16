package problem.p2xxx.p25xx.p2537m;

import problem.UtilityClass;

import java.util.HashMap;
import java.util.Map;

public class NumberofGoodSubarrays {
    public static long countGood(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        long equalPairs = 0;
        long goodSubArr = 0;
        Map<Integer, Long> freq = new HashMap<>();

        while (l < n){
            while (r < n  && equalPairs < k){
                freq.put(nums[r], freq.getOrDefault(nums[r], 0L) + 1);

                if (freq.get(nums[r]) >= 2){
                    equalPairs += freq.get(nums[r]) - 1;
                }
                r++;
            }

            if (equalPairs >= k){
                goodSubArr += n - r + 1;
            }

            // remove left item
            freq.put(nums[l], freq.get(nums[l]) - 1);
            if (freq.get(nums[l]) > 0){
                equalPairs -= freq.get(nums[l]);
            }
            l++;
        }

        return goodSubArr;
    }



    public static void main(String[] args) {
        int[] arr = {3,1,4,3,2,2,4};
        int k = 2;
        UtilityClass.logResult(countGood(arr, k));
    }
}
