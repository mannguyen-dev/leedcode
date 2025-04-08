package problem.p3xxx.p3396m;

import problem.UtilityClass;

import java.util.HashSet;
import java.util.Set;

public class ArrayDistinct {
    public static int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--){
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            } else{
                return (i/3) + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3,3,5,7};
        UtilityClass.logResult(minimumOperations(nums));
    }
}
