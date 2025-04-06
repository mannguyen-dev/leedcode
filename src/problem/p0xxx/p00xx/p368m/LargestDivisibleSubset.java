package problem.p0xxx.p00xx.p368m;

import problem.UtilityClass;

import java.util.*;

public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Map<String, Set<Integer>> cache = new HashMap<>();

        return dfs(0, 1, cache, nums).stream().toList();
    }

    private static Set<Integer> dfs(int i, int prev, Map<String, Set<Integer>> cache, int[] nums) {
        if (i == nums.length) return new HashSet<>();
        String cacheStr = i + "," + prev;
        if (cache.containsKey(cacheStr)) return cache.get(cacheStr);

        Set<Integer> res = dfs(i+1, prev, cache, nums);
        if (nums[i] % prev == 0){
            Set<Integer> temp = new HashSet<>(dfs(i + 1, nums[i], cache, nums));
            temp.add(nums[i]);
            res = (temp.size() > res.size()) ? temp : res;
        }
        cache.put(cacheStr, res);
        return res;
    }

    public static List<Integer> largestDivisibleSubset2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            List<Integer> temp = dfs2(i, nums, cache);
            if (temp.size() > res.size()) res = temp;

        }

        return res;
    }

    private static List<Integer> dfs2(int i, int[] nums, Map<Integer, List<Integer>> cache) {
        if ( i== nums.length) return new ArrayList<>();
        if (cache.containsKey(i)) return cache.get(i);
        List<Integer> res = new ArrayList<>();
        res.add(nums[i]);
        for (int j = i + 1; j < nums.length;j++){
            if (nums[j] % nums[i] == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.addAll(dfs2(j, nums, cache));
                if (temp.size() > res.size()) res = temp;
            }
        }
        cache.put(i, res);
        return res;
    }

    public static List<Integer> largestDivisibleSubset3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();
        for (int num: nums){
            List<Integer> list = new ArrayList<>();
            list.add(num);
            dp.add(list);
        }

        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = n-1; i >= 0 ; i--){
            for (int j = i + 1; j < n; j++){
                if (nums[j] % nums[i] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.addAll(dp.get(j));
                    if (temp.size() > dp.get(i).size())
                        dp.set(i, temp);
                }
            }
            if (dp.get(i).size() > res.size()) res = dp.get(i);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,6,24};
        UtilityClass.logResult(largestDivisibleSubset3(nums));
    }
}
