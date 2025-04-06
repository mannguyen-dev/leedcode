package problem.p0xxx.p01xx.p136e;

import problem.UtilityClass;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            if (!set.contains(num)){
                set.add(num);
            } else {
                set.remove(num);
            }
        }
        return set.iterator().next();
    }

    public static int singleNumber2(int[] nums) {
        int res = 0;
        for (int num:nums){
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        UtilityClass.logResult(singleNumber2(nums));
    }
}
