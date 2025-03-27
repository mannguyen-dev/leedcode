package problem.p2xxx.p20xx.p2206e;

import problem.UtilityClass;

import java.util.*;

public class DivideArrayIntoEqualPairs {
    public static boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }

        for (int num: map.keySet()){
            int val = map.get(num);
            if ((val & 1) == 1){
                return false;
            }
        }
        return true;
    }

    public static boolean divideArray2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }

        return set.isEmpty();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,2,2,2};
        UtilityClass.logResult(divideArray2(nums));
    }
}
