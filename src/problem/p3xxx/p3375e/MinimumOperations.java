package problem.p3xxx.p3375e;

import problem.UtilityClass;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperations {
    public static int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int num: nums){
            if (num < k){
                return -1;
            } else if (num > k) {
                set.add(num);
            }

        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {5,2,5,4,5};
        int k = 2;
        UtilityClass.logResult(minOperations(nums, k));
    }
}
