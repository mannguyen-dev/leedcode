package problem.p2xxx.p25xx.p2780m;

import problem.UtilityClass;

import java.util.Arrays;
import java.util.List;

public class MinimumIndexValidSplit {
    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        // step 1: Find the majority element
        int majorityElement = mooreVotingAlgo(nums);
        // step 2: Count the Frequency of majority element
        int majorityFreq = 0;
        for (int num: nums){
            if (majorityElement == num) majorityFreq++;
        }
        // step 3: now find the minimum valid split
        int prefixCount = 0;
        for (int i = 0; i<n; i++){
            if (nums.get(i) == majorityElement){
                prefixCount++;
                majorityFreq--;
            }

            if ((prefixCount > (i+1)/2) && majorityFreq > (n-i-1)/2){
                return i;
            }
        }
        return -1;
    }

    private static int mooreVotingAlgo(List<Integer> nums) {
        int majorityElement = nums.getFirst();
        int majorityFreq = 0;

        for (int num: nums){
            if (majorityElement == num){
                majorityFreq++;
            } else {
                majorityFreq--;
            }

            if (majorityFreq == 0){
                majorityElement = num;
                majorityFreq = 1;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,1,1,1,7,1,2,1};
        List<Integer> nums = Arrays.stream(arr).boxed().toList();
        UtilityClass.logResult(minimumIndex(nums));
    }
}
