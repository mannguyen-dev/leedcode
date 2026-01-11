package problem.p0xxx.p05xx.p961e;

import problem.UtilityClass;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElement {
    static void main() {
        int[] nums = new int[]{12,62,62,30,62,96,97,62,62,6,73,62,62,5,62,8,64,62,18,62};
        UtilityClass.logResult(repeatedNTimes(nums));
    }

    public static int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i: nums){
            if (!freq.containsKey(i)){
                freq.put(i, 1);
            } else {
                freq.put(i, freq.get(i) + 1);
            }
            if (freq.get(i) == n) return i;
        }
        return 0;
    }
}
