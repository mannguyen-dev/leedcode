package problem.p2570e;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        //
        HashMap<Integer, Integer> map = new HashMap<>();

        buildMap(nums1, map);
        buildMap(nums2, map);

        Set<Integer> keys = new TreeSet<>(map.keySet());

        int[][] ret = new int[keys.size()][2];
        int index = 0;
        for (Integer key : keys){
            ret[index][0] = key;
            ret[index][1] = map.get(key);
            index++;
        }

        return ret;
    }

    private static void buildMap(int[][] nums1, HashMap<Integer, Integer> map) {
        for (int[] ints : nums1) {
            if (map.containsKey(ints[0])) {
                map.compute(ints[0], (k, temp) -> temp + ints[1]);

            } else {
                map.put(ints[0], ints[1]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,3},{4,5}};
        int[][] arr2 = {{1,4},{3,2},{4,1}};
        System.out.println(Arrays.deepToString(mergeArrays(arr1, arr2)));
    }
}
